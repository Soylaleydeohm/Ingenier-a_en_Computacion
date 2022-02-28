#include <stdio.h>
#include <stdlib.h>

/**
* Este programa lee un número entero en base decimal y cuenta la cantidad de veces que aparece un dígito dado. *
**/

int pos_par(int num);

int pos_impar (int num){

    int valor;

    valor = 0;

    if (num < 10){
        valor = num;
    }
    else {
        valor = num % 10 + valor + pos_par(num/10);
    }

    //printf("Dígitos impares %i\n", digitos);

    return valor;

}

int pos_par(int num){

    int valor;

    valor = 0;

    //printf("Número %i\n", num);

    if (num < 10){
        valor = - num;
    }
    else {
        valor = - num % 10 +valor + pos_impar(num/10);
    }

    //printf("Dígitos pares %i\n", digitos);

    return valor;

}

int invertir (int num){

    int resto, inverso;
    inverso = 0;
    while (num != 0){

        resto = num % 10;
        num = num/10;
        inverso = inverso*10 + resto;
    }

    return inverso;
}


int main() {

    int numero, mediano;

    printf("Ingrese un número entero en base decimal. \n");

    scanf("%i", &numero);

    mediano = pos_impar(invertir(numero));

    printf("El mediano de %i es igual a %i.\n", numero, mediano);

    return 0;
}
