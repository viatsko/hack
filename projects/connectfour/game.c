#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <curses.h>
#include <string.h>

typedef struct t_gametable {
  char* array; // Game area
  int width; // width of game area
  int height; // height of game area
  char turn; 
  int players;
  int moves;
} gametable;

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

void nextTurn(gametable* game)
{
	if ((game->turn - '0') < game->players)
		game->turn++;
	else
		game->turn = '1';
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

void makeMove(gametable* game, int ch)
{
	char* c = game->array;
	int move, i = 1;
	char moved = '0';
	move = (ch - '0')-1;
	
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
			drawTable(game);
			game->moves++;
		}
	}
}

char hasWon(gametable* game, char ch)
{
	int i, j, x, y, flag, move_y, move_x = ch - '0';

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

int main()
{
	int i = 0, ch, width = 8, height = 8;
	
	char* input;
	
	gametable *game = newGame(width,height);
	game->players = 3;
	game->moves = 0;
	
	initscr();
	noecho();
	cbreak();
	intrflush(stdscr, FALSE); // Prevent interrupt flush
	keypad(stdscr,TRUE);
	
	start_color();
	init_pair(1, COLOR_RED, COLOR_BLACK);
	init_pair(2, COLOR_YELLOW, COLOR_BLACK);
	init_pair(3, COLOR_GREEN, COLOR_BLACK);
	init_pair(4, COLOR_BLUE, COLOR_BLACK);
	
	drawTable(game);
	
	while (1)
	{
		ch = getch();
		
		makeMove(game, ch);
		
		if (ch =='e')
			break;
		printw("%c",hasWon(game, ch));
	}	
		
	endwin();
	return 0;
}