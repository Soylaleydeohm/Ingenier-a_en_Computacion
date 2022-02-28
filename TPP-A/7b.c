#include <stdio.h>
#include <stdlib.h>

/**
* Este programa lee un número entero en base decimal y cuenta la cantidad de veces que aparece un dígito dado. *
**/

int contador (int num, int digit){

    int digitos;

    digitos = 0;

    if (num < 10 && num == digit){
        digitos = 1;
    }
    else if (num % 10 == digit){
        digitos = contador(num/10, digit) + 1;
    }

    return digitos;
}

int main() {

    int numero, digitos, digit;

    digitos = 0;

    printf("Ingrese un número entero en base decimal. \n");

    scanf("%i", &numero);

    printf("Ingrese el dígito de interés. \n");

    scanf("%i", &digit);

    digitos = contador(numero, digit);

    printf("En el número %i, el dígito %i aparece %i veces.\n", numero, digit, digitos);

    return 0;
}
