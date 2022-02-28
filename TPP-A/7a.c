#include <stdio.h>
#include <stdlib.h>

/**
* Este programa lee un número entero en base decimal y cuenta sus dígitos. *
**/

int contador (int num){

    int digitos;

    digitos = 0;

    if (num < 10){
        digitos = 1;
    }
    else{
        digitos = contador(num/10) + 1;
    }

    return digitos;
}

int main() {

    int numero, digitos;

    digitos = 0;

    printf("Ingrese un número entero en base decimal. \n");

    scanf("%i", &numero);

    digitos = contador(numero);

    printf("El número %i tiene %i dígitos.\n", numero, digitos);

    return 0;
}
