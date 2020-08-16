#ifndef _PROTOCOL_H_
#define _PROTOCOL_H_

enum {
    MSG_JOIN = 0,
    MSG_OK = 1,
    MSG_READY = 2,
    MSG_START = 3,
    MSG_TURN = 4,
    MSG_COLUMN = 5,
    MSG_AREA = 6,
    MSG_WINNER = 7,
    MSG_QUIT = 8,
    MSG_PING = 20,
    MSG_PONG = 21,
    MSG_CHAT_CLIENT = 10,
    MSG_CHAT_SERVER = 11,
    MSG_ERROR = 1000
} connectfour_packet_code;

struct connect_four_packet_common {
    long msg_code;
};

struct connect_four_packet_join {
    long msg_code;
};

struct connect_four_packet_ok {
    long msg_code;
    int player_count;
    int player_id;
};

struct connect_four_packet_ready {
    long msg_code;
};

struct connect_four_packet_start {
    long msg_code;
    int column_count;
    int row_count;
    int player_count;
};

struct connect_four_packet_turn {
    long msg_code;
};

struct connect_four_packet_column {
    long msg_code;
    int selected_column;
};

struct connect_four_packet_area {
    long msg_code;
    char area[BUFSIZE];
};

struct connect_four_packet_winner {
    long msg_code;
    int winner_id;
};

struct connect_four_packet_quit {
    long msg_code;
};

struct connect_four_packet_ping {
    long msg_code;
};

struct connect_four_packet_pong {
    long msg_code;
};

struct connect_four_packet_chat_client {
    long msg_code;
    long length;
    char msg[BUFSIZE];
};

struct connect_four_packet_chat_server {
    long msg_code;
    long length;
    int player_id;
    char msg[BUFSIZE];
};

struct connect_four_packet_error {
    long msg_code;
    int error_code;
    char message[BUFSIZE];
};

#endif