#include <stdio.h>
#include <stdlib.h>

int sorpresa_1(int a, int b){

    int toReturn;

    if (b == 0) toReturn = 1;

    else toReturn = sorpresa_1(a, b-1) * a;

    return toReturn;
}

int sorpresa_2(int a){

int toReturn;

    if (a < 10) toReturn = 1;

    else toReturn = 1 + sorpresa_2( a/10 );

return toReturn;

}

int sorpresa_3(int a){

    int toReturn, aux;

    if (a < 10) toReturn = a;

    else{

        aux = sorpresa_3(a/10);
        toReturn = (a % 10) * sorpresa_1(10,sorpresa_2(a)-1) + aux;

    }

    return toReturn;
}

int main(){

    printf("%d", sorpresa_3(12856));

return 0;
}
