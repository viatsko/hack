//
// Created by Valerii Iatsko on 08/01/16.
//

#include <stdio.h>

long abs(long value) {
    if (value < 0) {
        return -value;
    }
    else {
        return value;
    }
}

void update(int *a,int *b) {
    int ta = *a;
    int tb = *b;

    *a = ta + tb;
    *b = abs(ta - tb);
}

int main() {
    int a, b;
    int *pa = &a, *pb = &b;

    scanf("%d %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d", a, b);

    return 0;
}
