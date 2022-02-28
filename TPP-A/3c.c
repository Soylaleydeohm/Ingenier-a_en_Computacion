#include <stdio.h>
#include <stdlib.h>

/**
* Este programa convierte de litros cada 100 km a millas por galón. *
**/


float km_a_millas(float km) {

    float mi;

    mi = km / 1.609344;

    printf("100 km son %.4f millas\n", mi);

    return mi;
}

float litros_a_galon(float lit) {

    float galones;

    galones = 0.264172052 * lit;

    printf("%f litros son %.4f galones\n", lit, galones);

    return galones;
}

float conversor(float anterior) {

    float nuevo;

    nuevo = km_a_millas(100)/litros_a_galon(anterior);

    return nuevo;
}
int main() {


    float l_km, mpg;
    int seguir;
    char continuar;

    seguir = 1;
    continuar = 'A';

    while(seguir == 1){

        printf("Ingrese la medida de litros cada 100 km. \n");
        scanf("%f", &l_km);

        mpg = conversor(l_km);

        printf("La medida dada es %.4f millas por galón\n", mpg);

        printf("¿Desea convertir otra cantidad? Ingrese Y para seguir o N para finalizar.\n");
        scanf(" %c", &continuar);

        if (continuar == 'N'){
            seguir = 0;
        }
    }

    return 0;
}
