#include <stdio.h>
#include <stdlib.h>

/**
* Este programa convierte una velocidad en millas por hora a kilómetros por minuto. *
**/


float millas_a_km(float mi) {

    float km;

    km = 1.609344 * mi;

    return km;
}

float conversor(float v_ini) {

    float v_nueva;

    v_nueva = millas_a_km(v_ini) / 60.0;

    return v_nueva;
}
int main() {


    float vel,v_n;
    int seguir;
    char continuar;

    seguir = 1;
    continuar = 'A';

    while(seguir == 1){

        printf("Ingrese una velocidad en millas por hora. \n");
        scanf("%f", &vel);

        v_n = conversor(vel);

        printf("La velocidad dada es %.2f kilómetros por minuto\n", v_n);

        printf("¿Desea convertir otra velocidad? Ingrese Y para seguir o N para finalizar.\n");
        scanf(" %c", &continuar);

        if (continuar == 'N'){
            seguir = 0;
        }
    }

    return 0;
}
