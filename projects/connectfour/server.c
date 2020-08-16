#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <netdb.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <poll.h>
#include <time.h>
#include <fcntl.h>

#define BUFSIZE 900
#define MAX_PLAYERS 4
#define PING_TIMEOUT 30

#include "protocol.h"

static const char *param_udpport = NULL;
static const char *param_tcpport = NULL;

static const char *msg_invalid_packet_size = "Invalid packet size";

struct t_player {
    int free;
    int ready;
    int player_id;
    time_t ping;
    time_t pong;
    struct sockaddr_in addr;
} player;

typedef struct t_gametable {
    char* array; // Game area
    int width; // width of game area
    int height; // height of game area
    char turn;
    int players;
    int moves;
} gametable;

void run_networking();
int send_error_msg(int sockfd, const char *msg_text, struct sockaddr_in * clientaddr, int clientlen, int error_code);
void show_player_list();
void cleanup_players();

gametable* newGame (int width, int height);
void nextTurn(gametable* game);
void makeMove(gametable* game, int ch);
char hasWon(gametable* game, char ch);

static int players_connected = 0;
struct t_player players[MAX_PLAYERS];
struct t_gametable *game = NULL;

void error(char *msg) {
    perror(msg);
    exit(1);
}

int main(int argc, const char * argv[])
{
    int i, params_valid = 1;
    
    for(i = 0; i < argc; i++) {
        if(strcmp(argv[i], "-u") == 0) {
            if(i + 1 <= argc) {
                param_udpport = argv[++i];
            }
        } else if(strcmp(argv[i], "-t") == 0) {
            if(i + 1 <= argc) {
                param_tcpport = argv[++i];
            }
        }
    }

    if(param_udpport == NULL) {
        printf("udp port's not set, use -u <port> to set one\n");
        params_valid = 0;
    }
    
    if(param_tcpport == NULL) {
        printf("tcp port's not set, use -t <port> to set one\n");
        params_valid = 0;
    }
    
    if(!params_valid) {
        printf("Couldn't run server due to mis-configuration. Quitting.\n");
        return 1;
    }
    
    run_networking();
}

int send_error_msg(int sockfd, const char *msg_text, struct sockaddr_in * clientaddr, int clientlen, int error_code) {
    int n;
    
    struct connect_four_packet_error *packet_error = malloc(sizeof(struct connect_four_packet_error));
    packet_error->msg_code = 1000;
    packet_error->error_code = error_code;
    
    strcpy(packet_error->message, msg_text);
    
    n =  sendto(sockfd, packet_error, sizeof(*packet_error), 0, (struct sockaddr *)clientaddr, clientlen);
    
    free(packet_error);
    
    return n;
}

void show_player_list() {
    printf("=======\n");
    printf("Players connected: %d\n", players_connected);
    printf("=======\n");
    for(int i = 0; i < MAX_PLAYERS; i++) {
        printf("playerid = %d, free = %d, ready = %d, addr = %s, port = %d\n", players[i].player_id, players[i].free, players[i].ready, inet_ntoa(players[i].addr.sin_addr), ntohs(players[i].addr.sin_port));
    }
    printf("=======\n");
}

void cleanup_players() {
    for(int i = 0; i < MAX_PLAYERS; i++) {
        players[i].free = 1;
        players[i].ready = 0;
        players[i].player_id = i + 1;
        
        bzero((char *)&players[i].addr, sizeof(players[i].addr));
        
        players[i].ping = players[i].pong = time(0);
    }
}

void run_networking() {
    int udp_sockfd;
    int udp_portno;
    int udp_clientlen;
    struct sockaddr_in udp_serveraddr;
    struct sockaddr_in udp_clientaddr;
    struct hostent *udp_hostp;
    char buf[BUFSIZE];
    char *udp_hostaddrp;
    int udp_optval;
    int n;
    
    udp_portno = atoi(param_udpport);
    
    udp_sockfd = socket(AF_INET, SOCK_DGRAM, 0);
    
    if(udp_sockfd < 0) {
        error("ERROR opening udp socket");
    }
    
    udp_optval = 1;
    setsockopt(udp_sockfd, SOL_SOCKET, SO_REUSEADDR,
               (const void *)&udp_optval, sizeof(int));
    
    bzero((char *) &udp_serveraddr, sizeof(udp_serveraddr));
    udp_serveraddr.sin_family = AF_INET;
    udp_serveraddr.sin_addr.s_addr = htonl(INADDR_ANY);
    udp_serveraddr.sin_port = htons((unsigned short)udp_portno);
    
    if(bind(udp_sockfd, (struct sockaddr *)&udp_serveraddr, sizeof(udp_serveraddr)) < 0) {
        error("ERROR on udp binding");
    }
    
    udp_clientlen = sizeof(udp_clientaddr);
    
    // cleanup players list
    cleanup_players();
    
    int old_players_connected = 0;
    while(1) {
        bzero(buf, BUFSIZE);
        
        n = recvfrom(udp_sockfd, buf, BUFSIZE, 0, (struct sockaddr *)&udp_clientaddr, &udp_clientlen);
        
        if(n < 0) {
            error("ERROR in recvfrom");
        }
        
        old_players_connected = players_connected;
        for(int i = 0; i < MAX_PLAYERS; i++) {
            if(!players[i].free) {
                if(abs(players[i].ping - time(0)) > PING_TIMEOUT / 2) {
                    struct connect_four_packet_ping * packet_ping = malloc(sizeof(struct connect_four_packet_ping));
                    packet_ping->msg_code = MSG_PING;
                    
                    printf("PING %s %d\n", inet_ntoa(players[i].addr.sin_addr), ntohs(players[i].addr.sin_port));
                    
                    players[i].ping = time(0);
                    
                    printf("PING diff %lu %lu\n", players[i].ping, players[i].pong);
                    
                    if(abs(players[i].ping - players[i].pong) >= PING_TIMEOUT) {
                        players[i].free = 1;
                        players_connected--;
                        continue;
                    }
                    
                    n = sendto(udp_sockfd, packet_ping, sizeof(*packet_ping), 0, &players[i].addr, sizeof(players[i].addr));
                }
            }
        }
        
        if(old_players_connected > players_connected) {
            show_player_list();
        }
        
        struct connect_four_packet_common *recvpacket = buf;
        
        printf("Got packet with message code: %ld\n", recvpacket->msg_code);
        
        switch(recvpacket->msg_code) {
            case MSG_PONG:
                {
                    struct connect_four_packet_pong *packet_pong = recvpacket;
                    
                    for(int i = 0; i < MAX_PLAYERS; i++) {
                        if((players[i].addr.sin_addr.s_addr == udp_clientaddr.sin_addr.s_addr) &&
                           (players[i].addr.sin_port == udp_clientaddr.sin_port)) {
                            players[i].pong = time(0);
                        }
                    }
                }
                break;
            case MSG_JOIN:
                {
                    if(game != NULL) {
                        n = send_error_msg(udp_sockfd, "Game running. New clients are not allowed.", &udp_clientaddr, udp_clientlen, 1);
                        break;
                    }
                    
                    int free_slot_id = -1;
                    int player_exists = 0;
                    for(int i = 0; i < MAX_PLAYERS; i++) {
                        if(players[i].free) {
                            if(free_slot_id == -1) {
                                free_slot_id = i;
                            }
                        }
                        
                        if((players[i].addr.sin_addr.s_addr == udp_clientaddr.sin_addr.s_addr) &&
                           (players[i].addr.sin_port == udp_clientaddr.sin_port)) {
                            player_exists = 1;
                        }
                    }
                    
                    if(player_exists) {
                        n = send_error_msg(udp_sockfd, "You are already registered for a game.", &udp_clientaddr, udp_clientlen, 0);
                    } else if(free_slot_id == -1) {
                        n = send_error_msg(udp_sockfd, "Game full. New clients are not allowed.", &udp_clientaddr, udp_clientlen, 2);
                    } else {
                        players_connected++;
                        players[free_slot_id].addr.sin_family = AF_INET;
                        players[free_slot_id].addr.sin_addr.s_addr = udp_clientaddr.sin_addr.s_addr;
                        players[free_slot_id].addr.sin_port = udp_clientaddr.sin_port;
                        players[free_slot_id].free = 0;
                        players[free_slot_id].ready = 0;
                        
                        struct connect_four_packet_ok *packet_ok = malloc(sizeof(struct connect_four_packet_ok));
                        packet_ok->msg_code = MSG_OK;
                        packet_ok->player_count = players_connected;
                        packet_ok->player_id = players[free_slot_id].player_id;
                        
                        n = sendto(udp_sockfd, packet_ok, sizeof(*packet_ok), 0, (struct sockaddr *)&udp_clientaddr, udp_clientlen);
                        
                        free(packet_ok);
                    }
                    
                    show_player_list();
                }
                break;
            case MSG_READY:
                {
                    int ready_players = 0;
                    for(int i = 0; i < MAX_PLAYERS; i++) {
                        if(!players[i].free) {
                            if((players[i].addr.sin_addr.s_addr == udp_clientaddr.sin_addr.s_addr) &&
                               (players[i].addr.sin_port == udp_clientaddr.sin_port)) {
                                players[i].ready = 1;
                            }
                            
                            if(players[i].ready) {
                                ready_players++;
                            }
                        }
                    }
                    
                    printf("START ready_players %d players_connected %d", ready_players, players_connected);
                    if((ready_players >= 2) && (players_connected == ready_players)) {
                        /*
                         * Everyone's ready, let's start the game!
                         */
                        struct connect_four_packet_start *packet_start = malloc(sizeof(struct connect_four_packet_start));
                        packet_start->msg_code = MSG_START;
                        
                        switch(players_connected) {
                            case 2:
                                packet_start->column_count = 6;
                                packet_start->row_count = 7;
                                break;
                            case 3:
                            case 4:
                                packet_start->column_count = 7;
                                packet_start->row_count = 9;
                                break;
                        }
                        
                        game = newGame(packet_start->column_count, packet_start->row_count);
                        game->players = players_connected;
                        
                        packet_start->player_count = players_connected;
                        
                        
                        for(int i = 0; i < MAX_PLAYERS; i++) {
                            if(!players[i].free)
                                n = sendto(udp_sockfd, packet_start, sizeof(*packet_start), 0, &players[i].addr, sizeof(players[i].addr));
                        }
                        
                        free(packet_start);
                        
                        for(int i = 0; i < MAX_PLAYERS; i++) {
                            if(!players[i].free) {
                                if(players[i].player_id == (game->turn - '0')) {
                                    struct connect_four_packet_turn *packet_turn = malloc(sizeof(struct connect_four_packet_turn));
                                    
                                    packet_turn->msg_code = MSG_TURN;
                                    
                                    sendto(udp_sockfd, packet_turn, sizeof(*packet_turn), 0, &players[i].addr, sizeof(players[i].addr));
                                    
                                    free(packet_turn);
                                    break;
                                }
                            }
                        }
                    }
                    
                    show_player_list();
                }
                break;
            case MSG_COLUMN:
                {
                    if(game == NULL) {
                        n = send_error_msg(udp_sockfd, "Game's not started yet.", &udp_clientaddr, udp_clientlen, 3);
                        break;
                    }
                    
                    int valid_player = 0;
                    for(int i = 0; i < MAX_PLAYERS; i++) {
                        if(!players[i].free) {
                            if((players[i].addr.sin_addr.s_addr == udp_clientaddr.sin_addr.s_addr) &&
                               (players[i].addr.sin_port == udp_clientaddr.sin_port) &&
                               (players[i].player_id == (game->turn - '0'))) {
                                int old_moves = game->moves;
                                
                                struct connect_four_packet_column *packet_column = buf;
                                makeMove(game, packet_column->selected_column);
                                
                                char winner = hasWon(game, packet_column->selected_column);
                                
                                struct connect_four_packet_area *packet_area = malloc(sizeof(struct connect_four_packet_area));
                                packet_area->msg_code = MSG_AREA;
                                game->array[game->height * game->width] = 0;
                                strcpy(packet_area->area, game->array);
                                
                                printf("=======\n");
                                printf("Sending game data: %s", packet_area->area);
                                printf("=======\n");
                                
                                for(int i = 0; i < MAX_PLAYERS; i++) {
                                    if(!players[i].free)
                                        n = sendto(udp_sockfd, packet_area, sizeof(*packet_area), 0, &players[i].addr, sizeof(players[i].addr));
                                }
                                
                                free(packet_area);
                                
                                if((winner != 'f') || (game->moves == game->width * game->height)) {
                                    struct connect_four_packet_winner *packet_winner = malloc(sizeof(struct connect_four_packet_winner));
                                    
                                    packet_winner->msg_code = MSG_WINNER;
                                    if(winner == 'f') {
                                        packet_winner->winner_id = 0;
                                    } else {
                                        packet_winner->winner_id = winner - '0';
                                    }
                                    
                                    for(int i = 0; i < MAX_PLAYERS; i++) {
                                        if(!players[i].free)
                                            n = sendto(udp_sockfd, packet_winner, sizeof(*packet_winner), 0, &players[i].addr, sizeof(players[i].addr));
                                    }
                                    
                                    free(packet_winner);
                                    
                                    cleanup_players();
                                    
                                    free(game);
                                    game = NULL;
                                } else {
                                    for(int i = 0; i < MAX_PLAYERS; i++) {
                                        if(!players[i].free) {
                                            if(players[i].player_id == (game->turn - '0')) {
                                                struct connect_four_packet_turn *packet_turn = malloc(sizeof(struct connect_four_packet_turn));
                                                
                                                packet_turn->msg_code = MSG_TURN;
                                                
                                                sendto(udp_sockfd, packet_turn, sizeof(*packet_turn), 0, &players[i].addr, sizeof(players[i].addr));
                                                
                                                free(packet_turn);
                                                break;
                                            }
                                        }
                                    }
                                }
                                
                                if(game != NULL) {
                                    if(old_moves == game->moves) {
                                        n = send_error_msg(udp_sockfd, "Column full. Select another.", &udp_clientaddr, udp_clientlen, 4);
                                        break;
                                    }
                                }
                                
                                valid_player = 1;
                                break;
                            }
                        }
                    }
                    
                    if(!valid_player) {
                        n = send_error_msg(udp_sockfd, "It's not your turn!", &udp_clientaddr, udp_clientlen, 0);
                    }
                }
                break;
            case MSG_QUIT:
                for(int i = 0; i < MAX_PLAYERS; i++) {
                    printf("QUIT issued\n");
                    printf("%u\n = %u\n", players[i].addr.sin_addr.s_addr, udp_clientaddr.sin_addr.s_addr);
                    printf("%hu\n = %hu\n", players[i].addr.sin_port, udp_clientaddr.sin_port);
                    if((players[i].addr.sin_addr.s_addr == udp_clientaddr.sin_addr.s_addr) &&
                       (players[i].addr.sin_port == udp_clientaddr.sin_port)) {
                        bzero((char *)&players[i].addr, sizeof(players[i].addr));
                        players[i].free = 1;
                        players_connected--;
                    }
                }
                show_player_list();
                break;
            case MSG_CHAT_CLIENT:
                {
                    struct connect_four_packet_chat_client * packet_chat_client = recvpacket;
                    
                    struct connect_four_packet_chat_server * packet_chat_server = malloc(sizeof(struct connect_four_packet_chat_server));
                    packet_chat_server->msg_code = MSG_CHAT_SERVER;
                    
                    strcpy(packet_chat_server->msg, packet_chat_client->msg);
                    packet_chat_server->length = strlen(packet_chat_server->msg);
                    
                    for(int i = 0; i < MAX_PLAYERS; i++) {
                        if((players[i].addr.sin_addr.s_addr == udp_clientaddr.sin_addr.s_addr) &&
                           (players[i].addr.sin_port == udp_clientaddr.sin_port)) {
                            packet_chat_server->player_id = players[i].player_id;
                        }
                    }
                    
                    for(int i = 0; i < MAX_PLAYERS; i++) {
                        if(!players[i].free)
                            n = sendto(udp_sockfd, packet_chat_server, sizeof(*packet_chat_server), 0, &players[i].addr, sizeof(players[i].addr));
                    }
                    
                    
                    free(packet_chat_server);
                }
                break;
            case MSG_CHAT_SERVER:
                // implemented
            case MSG_AREA:
                // implemented
            case MSG_TURN:
                // implemented
            case MSG_START:
                // implemented
            case MSG_OK:
                // implemented
            case MSG_WINNER:
                // implemented
                n = send_error_msg(udp_sockfd, "Got server-answer command from client.", &udp_clientaddr, udp_clientlen, 0);
                break;
            default:
                if(n < 2) {
                    n = send_error_msg(udp_sockfd, "Unknown command received.", &udp_clientaddr, udp_clientlen, 0);
                } else {
                    udp_hostp = gethostbyaddr((const char*)&udp_clientaddr.sin_addr.s_addr, sizeof(udp_clientaddr.sin_addr.s_addr), AF_INET);
                    
                    if(udp_hostp == NULL) {
                        error("ERROR on gethostbyaddr");
                    }
                    
                    udp_hostaddrp = inet_ntoa(udp_clientaddr.sin_addr);
                    
                    if(udp_hostaddrp == NULL) {
                        error("ERROR on inet_ntoa");
                    }
                    
                    n = sendto(udp_sockfd, buf, strlen(buf), 0, (struct sockaddr *)&udp_clientaddr, udp_clientlen);
                }
                break;
        }
        
        if(n < 0) {
            error("ERROR in sendto");
        }
    }
}

gametable* newGame (int width, int height) {
	gametable *game = (gametable*)malloc(sizeof(gametable));
	game->array = (char*)malloc(width*height);
	game->width = width;
	game->height = height;
	game->turn = '1';
	memset(game->array,'0',width*height);
	
	return game;
}

void nextTurn(gametable* game)
{
	if ((game->turn - '0') < game->players)
		game->turn++;
	else
		game->turn = '1';
}

void makeMove(gametable* game, int ch)
{
	char* c = game->array;
	int move, i = 1;
	char moved = '0';
	move = (ch)-1;
	
	if (move >= 0 && move < game->width)
	{
		c += move*sizeof(char);
		while (*c == '0' && i < game->height)
		{
			i++;
			c += (game->width)*sizeof(char);
			if (*c != '0' && i > 1)
			{
				c -= game->width;
				*c = game->turn;
				moved = '1';
				break;
			} else if (*c != '0' && i == 1)
			{
				//printw("Invalid move.");
				break;
			}
			if (i == game->height)
			{
				*c = game->turn;
				moved = '1';
				break;
			}
		}
		if (moved == '1')
		{
			nextTurn(game);
			//drawTable(game);
            
            // %)
            
			game->moves++;
		}
	}
}

char hasWon(gametable* game, char ch)
{
	int i, j, x, y, flag, move_y, move_x = ch;
    
	// Getting y-coordinate of the last move
	char* c = game->array;
	c += (move_x-1);
	for (i = 1; i <= game->height; i++)
	{
		if (*c != '0')
		{
			move_y = i;
			break;
		}
		c += game->width;
	}
    
	// Checking horizontally
	if (move_x >= 4)
		x = move_x - 3;
	else
		x = 1;
	y = move_y;
	flag = 0;
	for (i = 0; i<(game->width-(x-2));i++)
	{
		if (game->array[(x+i-1)+(move_y-1)*game->width] == game->array[move_x-1+(move_y-1)*game->width])
		{
			flag++;
			if (flag >= 4)
				return game->array[(move_x-1)+(move_y-1)*game->width];
		}
		else
			flag = 0;
	}
	// Checking vertically
	if (move_y >= 4)
		y = move_y - 3;
	else
		y = 1;
	x = move_x;
	flag = 0;
	for (i = 0; i<(game->height-(y-2));i++)
	{
		if (game->array[(x-1)+(move_y+i-1)*game->width] == game->array[move_x-1+(move_y-1)*game->width])
		{
			flag++;
			if (flag >= 4)
				return game->array[(move_x-1)+(move_y-1)*game->width];
		}
		else
			flag = 0;
	}
	// Checking diagonally from upper left to lower right (positive x and positive y)
	if (move_x >= 4 && move_y >= 4)
	{
		x = move_x - 3;
		y = move_y - 3;
	}
	else if (move_x < 4 || move_y < 4)
	{
		if (move_x >= move_y)
		{
			y = 1;
			x = move_x-(move_y-1);
		}
		else
		{
			x = 1;
			y = move_y-(move_x-1);
		}
	}
	flag = 0;
	for (i = 0; i<(game->width-(x-2)) && i<(game->height-(y-2));i++)
	{
		if (game->array[(x+i-1)+(y+i-1)*game->width] == game->array[move_x-1+(move_y-1)*game->width])
		{
			flag++;
			if (flag >= 4)
				return game->array[(move_x-1)+(move_y-1)*game->width];
		}
		else
			flag = 0;
	}
    
	// Checking diagonally from lower left to upper right (positive x and negative y)
	if (move_x >= 4 && (move_y <= game->height-4))
	{
		x = move_x - 3;
		y = move_y + 3;
	}
	else if (move_x < 4 || move_y > game->height-4)
	{
		if (move_x >= (game->height-(move_y-1)))
		{
			y = game->height;
			x = move_x-(game->height-move_y);
		}
		else
		{
			x = 1;
			y = move_y+(move_x-1);
		}
	}
	flag = 0;
	for (i = 0; i<(game->width-(x-2)) && i<y ;i++)
	{
		if (game->array[(x+i-1)+(y-i-1)*game->width] == game->array[move_x-1+(move_y-1)*game->width])
		{
			flag++;
			if (flag >= 4)
				return game->array[(move_x-1)+(move_y-1)*game->width];
		}
		else
			flag = 0;
	}
	return('f');
}
