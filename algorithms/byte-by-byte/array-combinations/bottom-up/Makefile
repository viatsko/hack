CC=g++
CXXFLAGS=-O2 -std=c++1z -Wno-missing-braces -Wextra
OUTPUTNAME=array-combinations-bottom-up
OBJS=array-combinations-bottom-up.o

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
