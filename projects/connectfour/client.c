#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <curses.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <sys/time.h>
#include <fcntl.h>

#define BUFSIZE 1024

#include "protocol.h"

typedef struct t_gametable {
  char* array; // Game area
  int width; // width of game area
  int height; // height of game area
  char turn; 
  int players;
  int moves;
} gametable;

static const char *param_hostname = NULL;
static const char *param_udpport = NULL;
static const char *param_tcpport = NULL;

gametable* newGame (int width, int height)
{
	gametable *game = (gametable*)malloc(sizeof(gametable));
	game->array = (char*)malloc(width*height);
	game->width = width;
	game->height = height;
	game->turn = '1';
	memset(game->array,'0',width*height);
	
	return game;
}

void drawTable(gametable* game)
{
	int i, j, width = game->width, height = game->height;
	char* c = game->array;
	
	clear();
	
	for(i = 0; i < width; i++)
		printw("  %d ",i+1);
	printw("\n");
	for (j = 0; j < 4*width; j++)
		printw("_");
	printw("\n");
	for(i = 0; i < height; i++)
	{
		for (j=0; j < width; j++)
		{	
			printw("| ");
			if (*c == '1')
				attron(COLOR_PAIR(1));
			else if (*c == '2')
				attron(COLOR_PAIR(2));
			else if (*c == '3')
				attron(COLOR_PAIR(3));
			else if (*c == '4')
				attron(COLOR_PAIR(4));
			printw("%c ", *c++);

			attroff(COLOR_PAIR(1));
			attroff(COLOR_PAIR(2));
		}
		printw("|\n");
	}
	for (j = 0; j < 4*width; j++)
		printw("-");
	printw("\n");
}

int main(int argc, char** argv)
{
	int i = 0, params_valid = 1;
	char c, *udp_addr;
	gametable* game = NULL;
	
	int udp_sockfd,n, udp_port;
	struct sockaddr_in udp_servaddr,cliaddr;
	char sendline[1000];
	char recvline[1000];
	
	for(i = 0; i < argc; i++) {
		if(strcmp(argv[i], "-h") == 0) {
			if(i + 1 <= argc) {
				udp_addr = argv[++i];
			}
		} else if(strcmp(argv[i], "-u") == 0) {
			if(i + 1 <= argc) {
				udp_port = atoi(argv[++i]);
			}
		} /*else if(strcmp(argv[i], "-t") == 0) {
			if(i + 1 <= argc) {
				param_tcpport = argv[++i];
			}
		} */
	}
    
    if(udp_addr == NULL) {
        printf("hostname's not set, use -h <hostname> to set one\n");
        params_valid = 0;
    }
    
    if(udp_port == NULL) {
        printf("udp port's not set, use -u <port> to set one\n");
        params_valid = 0;
    }
    /*
    if(param_tcpport == NULL) {
        printf("tcp port's not set, use -t <port> to set one\n");
        params_valid = 0;
    }*/
    
    if(!params_valid) {
        printf("Couldn't run server due to mis-configuration. Quitting.\n");
        return 1;
    }
	
	initscr();
	intrflush(stdscr, FALSE); // Prevent interrupt flush
	keypad(stdscr,TRUE);
	timeout(0);
	
	start_color();
	init_pair(1, COLOR_RED, COLOR_BLACK);
	init_pair(2, COLOR_YELLOW, COLOR_BLACK);
	init_pair(3, COLOR_GREEN, COLOR_BLACK);
	init_pair(4, COLOR_BLUE, COLOR_BLACK);
	
	// client
	udp_sockfd=socket(AF_INET,SOCK_DGRAM,0);

	int flags = fcntl(udp_sockfd, F_GETFL);
	flags |= O_NONBLOCK;
	fcntl(udp_sockfd, F_SETFL, flags);
	
	bzero(&udp_servaddr,sizeof(udp_servaddr));
	udp_servaddr.sin_family = AF_INET;
	udp_servaddr.sin_addr.s_addr=inet_addr(udp_addr);
	udp_servaddr.sin_port=htons(udp_port);

	//printw("%s %d", udp_addr, udp_port);
	printw("Commands: /join, /ready, /area, /place <column>, /chat <message>, /quit\n");
	
	char c_input[100], c_input_copy[100];
	
	while (1) {
		sleep(0.01);
		
		// try receiving packet from server
		struct connect_four_packet_common * packet_recv = recvline;
    
        n=recvfrom(udp_sockfd,packet_recv,10000,0,NULL,NULL);
        recvline[n]=0;

        if (n > 2)
		{
			//printw("Got packet code %lu\n", packet_recv->msg_code);
			// parse packet
			switch(packet_recv->msg_code)
			{
				case 1000:
					printw(" %s\n", ((struct connect_four_packet_error *)packet_recv)->message);
					break;
				case 1:
					printw("Game joined. Type /ready when you're ready.\n");
					break;
				case 3:
					{
						struct connect_four_packet_start * packet_start = packet_recv;
						game = newGame(packet_start->column_count, packet_start->row_count);
						printw("Game started. %d players, game size %dx%d.\n", packet_start->player_count, game->width, game->height);
					}
					break;
				case 4:
					printw("Your turn. Select column with /place <number>\n");
					break;
				case 6:
				{
					struct connect_four_packet_area * packet_area = packet_recv;
					printw("%s", packet_area->area);
					strcpy(game->array, packet_area->area);
					drawTable(game);
					break;
				}
				case 7:
					printw("Player %d won!\n", ((struct connect_four_packet_winner *)packet_recv)->winner_id);
					printw("Type /join for a new game.\n");
					break;
				case 11:
					printw("%d: %s\n",((struct connect_four_packet_chat_server *)packet_recv)->player_id, ((struct connect_four_packet_chat_server *)packet_recv)->msg);
					break;
				case 20:
				{
					struct connect_four_packet_pong *packet_pong = malloc(sizeof(struct connect_four_packet_pong));
					packet_pong->msg_code = 21;
					sendto(udp_sockfd, packet_pong, sizeof(*packet_pong), 0,  (struct sockaddr *)&udp_servaddr, sizeof(udp_servaddr));
					free(packet_pong);
				}
			}
		}
		// if there's input, deactivate non-blocking input and read a line
		c = getch();
		if (c == ERR)
			continue;
		else 
			timeout(-1);
		getstr(c_input);
		//printw("%s\n", c_input);
		timeout(0);
		strcpy(c_input_copy, c_input);
		
		char *command = strtok(c_input_copy, " ");
		
		// parse commands, assign message codes based on them and send a packet
		if (strcmp(command, "quit") == 0)
		{
			struct connect_four_packet_quit *packet_quit = malloc(sizeof(struct connect_four_packet_quit));
			packet_quit->msg_code = 8;
			sendto(udp_sockfd, packet_quit, sizeof(*packet_quit), 0,  (struct sockaddr *)&udp_servaddr, sizeof(udp_servaddr));
			free(packet_quit);
			break;
		}
		else if (strcmp(command, "join") == 0)
		{
			struct connect_four_packet_join *packet_join = malloc(sizeof(struct connect_four_packet_join));
			packet_join->msg_code = 0;
			sendto(udp_sockfd, packet_join, sizeof(*packet_join), 0,  (struct sockaddr *)&udp_servaddr, sizeof(udp_servaddr));
			free(packet_join);
		}
		else if (strcmp(command, "ready") == 0)
		{
			struct connect_four_packet_ready *packet_ready = malloc(sizeof(struct connect_four_packet_ready));
			packet_ready->msg_code = 2;
			sendto(udp_sockfd, packet_ready, sizeof(*packet_ready), 0,  (struct sockaddr *)&udp_servaddr, sizeof(udp_servaddr));
			free(packet_ready);
		}
		else if (strcmp(command, "place") == 0)
		{
			struct connect_four_packet_column *packet_column = malloc(sizeof(struct connect_four_packet_column));
			packet_column->msg_code = 5;
			packet_column->selected_column = atoi(strtok(NULL, " "));
			sendto(udp_sockfd, packet_column, sizeof(*packet_column), 0,  (struct sockaddr *)&udp_servaddr, sizeof(udp_servaddr));
			free(packet_column);
		}
		else if (strcmp(command, "chat") == 0)
		{
			char* text = c_input;
			text = text + 5;
			
			struct connect_four_packet_chat_client *packet_chat_client = malloc(sizeof(struct connect_four_packet_chat_client));
			packet_chat_client->msg_code = 10;
			strcpy(packet_chat_client->msg, text);
			packet_chat_client->length = strlen(text);
			sendto(udp_sockfd, packet_chat_client, sizeof(*packet_chat_client), 0,  (struct sockaddr *)&udp_servaddr, sizeof(udp_servaddr));
			free(packet_chat_client);
		}
	}
	endwin();
}