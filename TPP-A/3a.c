#include <stdio.h>
#include <stdlib.h>

/**
* Este programa convierte una temperatura de grados Celsius a grados Farenheit. *
**/


float celsius_a_farenheit(float temp) {

    float faren;

    printf("%d", temp);

    faren = 9.0*(temp/5.0)+32.0;

    return faren;
}

int main() {


    float temperatura, en_faren;
    int seguir;
    char continuar;

    seguir = 1;
    continuar = 'A';

    //temperatura = 0;
    //en_faren = 0;

    while(seguir == 1){

        printf("Ingrese una temperatura en grados celsius. \n");
        scanf("%f", &temperatura);

        en_faren = celsius_a_farenheit(temperatura);

        printf("La temperatura %f en grados Celsius es %.2f grados Farenheit\n", temperatura, en_faren);

        printf("¿Desea convertir otra temperatura? Ingrese Y para seguir o N para finalizar.\n");
        scanf(" %c", &continuar);

        if (continuar == 'N'){
            seguir = 0;
        }
    }

    return 0;
}

