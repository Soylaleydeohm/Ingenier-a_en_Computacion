#include <stdio.h>
#include <stdlib.h>

/**
* Este programa lee un número entero en base decimal y determina si es o no prolijo, es decir, si sus dígitos aparecen en orden estrictamente ascendente o descendente. *
**/

int ascendente (long int num){

    int prolijo;
    long int aux_1, aux_2;

    printf("long int que recibe ascendente %li \n", num);

    prolijo = 1;

    aux_1 = num % 10;
    aux_2 = (num/10) % 10;

    printf("aux_1 es %li \n", aux_1);
    printf("aux_2 es %li\n", aux_2);

    if(aux_1 >= aux_2){
        printf("aux_1 %li que es el posterior es mayor que aux_ 2 %li en el caso ascendente\n", aux_1, aux_2);
        prolijo = 0;
    } else if (num >= 100){
        prolijo = ascendente(num/10);
    }

    return prolijo;

}

int descendente(long int num){

    int prolijo;
    long int aux_1, aux_2;

    printf("long int que recibe descendente %li \n", num);

    prolijo = 1;

    aux_1 = num % 10;
    aux_2 = (num/10) % 10;

    printf("aux_1 es %li\n", aux_1);
    printf("aux_2 es %li\n", aux_2);

    if(aux_1 <= aux_2){
        printf("aux_1 %li que es el posterior es menor que aux_ 2 %li en el caso descendente\n", aux_1, aux_2);
        prolijo = 0;
    } else if (num >= 100){
        prolijo = descendente(num/10);
    }

    return prolijo;

}

int es_prolijo (long int num){

    int prolijo;

    prolijo = 0;

    if (num < 10 || descendente(num) == 1 || ascendente(num) == 1){
        prolijo = 1;
    }

    return prolijo;
}


int main() {

    long int numero;
    int prolijo;

    printf("Ingrese un número entero en base decimal. \n");

    scanf("%li", &numero);

    prolijo = es_prolijo(numero);

    if (prolijo == 0){
        printf("El número %i no es prolijo", numero);
    } else {
        printf("El número %i es prolijo", numero);
    }



    return 0;
}

