#!/usr/bin/env python


def search_inside(G, P, R, C, r, c):
    for i in range(R - r + 1):
        for j in range(C - c + 1):
            valid = True
            for k in range(r):
                #print G[i + k][j:j + c]
                if G[i + k][j:j + c] != P[k]:
                    valid = False
                    break

            if valid:
                print 'YES'
                return

    print 'NO'


t = int(raw_input().strip())

for _ in range(t):
    R, C = map(int, raw_input().strip().split())

    G = []

    for G_i in range(R):
        G_t = str(raw_input().strip())
        G.append(G_t)

    r, c = map(int, raw_input().strip().split())

    P = []

    for P_i in range(r):
        P_t = str(raw_input().strip())
        P.append(P_t)

    search_inside(G, P, R, C, r, c)
