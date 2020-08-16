CC=gcc
CFLAGS=-w -std=gnu99 -I.
LIBS=-lncurses

default: c4client c4server

clean:
	rm -f c4client c4server

c4client:
	$(CC) $(CFLAGS) $(LIBS) -o c4client client.c

c4server:
	$(CC) $(CFLAGS) -o c4server server.c
