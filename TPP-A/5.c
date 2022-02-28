#include <stdio.h>
#include <stdlib.h>

/**
* Este programa lee un número entero en notación binaria y lo convierte en su equivalente en base decimal. *
**/

int conversor (int num){

    int nuevo;

    nuevo = 0;

    if (num == 0 || num == 1){
        nuevo = num;
    }
    else{
        nuevo = conversor(num/10) *2 + num % 10;
    }

    return nuevo;
}

int main() {

    int n_binario, n_decimal;

    printf("Ingrese un número entero en notación binaria. \n");

    scanf("%i", &n_binario);

    n_decimal = conversor(n_binario);

    printf("El número %i en notación binaria, es equivalente al número %i en base decimal.\n", n_binario, n_decimal);

    return 0;
}
