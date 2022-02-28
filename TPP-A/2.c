#include <stdio.h>
#include <stdlib.h>

/**
* Este programa convierte un número entero positivo que representa a una cantidad de segundos en hh:mm:ss. *
**/


void conversion(long int segundos) {

    int h, m, s;
    float aux_m;

    h = (int) segundos / 3600;
    aux_m = (int) segundos % 3600;
    m = (int) aux_m / 60;
    s = (int) aux_m % 60;

    printf("La cantidad de segundos ingresada corresponde al tiempo: %i:%i:%i, con formato hh:mm:ss \n", h,  m, s);

}

int main() {

    long int segundos;
    int h, m, s, seguir;
    char continuar;

    seguir = 1;
    continuar = 'A';

    while(seguir == 1){

        printf("Ingrese un número entero positivo. \n");
        scanf("%i", &segundos);

        conversion(segundos);

        printf("¿Desea convertir otra cantidad de segundos? Ingrese Y para seguir o N para finalizar.\n");
        scanf(" %c", &continuar);

        if (continuar == 'N'){
            seguir = 0;
        }
    }

    return 0;
}
