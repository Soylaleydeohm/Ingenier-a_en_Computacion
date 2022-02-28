#include <stdio.h>
#include <stdlib.h>

int funcion_1(int a){ return a<<4; }

int funcion_2(int a){ return a>>2; }

int funcion_3(int a, int b){ return a & b; }

int funcion_4(int a, int b){ return a | b; }

int main(){

    printf("%d\n", funcion_1(10));
    printf("%d\n", funcion_1(15));

    printf("\n");

    printf("%d\n", funcion_2(28));
    printf("%d\n", funcion_2(155));
    printf("%d\n", funcion_2(197));

    printf("\n");

    printf("%d\n", funcion_3(421,0));
    printf("%d\n", funcion_3(136,8));
    printf("%d\n", funcion_3(136,15));
    printf("%d\n", funcion_3(136,128));

    printf("\n");

    printf("%d\n", funcion_4(126,1));
    printf("%d\n", funcion_4(127,128));
    printf("%d\n", funcion_4(27,4));
    printf("%d\n", funcion_4(31,4));

    return 0;
}
