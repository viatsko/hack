CC=g++
CXXFLAGS=-O2 -std=c++17 -Wno-missing-braces -Wextra
OUTPUTNAME=square-submatrix-bottom-up
OBJS=square-submatrix-bottom-up.o

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
