CC=g++
CXXFLAGS=-O2 -std=c++11 -Wall
OUTPUTNAME=fib-bruteforce
OBJS=fib-bruteforce.o

default: all

all: $(OBJS)
	$(CC) $(CFLAGS) -o $(OUTPUTNAME) $(OBJS)

debug: $(OBJS)
	$(CC) $(CFLAGS) -g -o $(OUTPUTNAME) $(OBJS)

opt: $(OBJS)
	$(CC) $(CFLAGS) -O3 -o $(OUTPUTNAME) $(OBJS)

.PHONY: clean
clean:
	rm *.o
	rm $(OUTPUTNAME)
