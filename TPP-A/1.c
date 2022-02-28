#include <stdio.h>
#include <stdlib.h>

/**
* Este programa verifica si una fecha ingresada por el usuario es válida. Se consideran válidas fechas con años negativos. *
**/


/**
* Esta funcion comprueba si el año es bisiesto. *
* Devuelve 1 si es bisiesto, y 0 si no lo es *
**/

int es_bisiesto(int anio){

    int es_b = 0;

    if (anio % 400 == 0 || (anio % 4 == 0 && anio % 100 != 0)){
        es_b = 1;
    }
    return es_b;
}

/**
* Esta funcion comprueba si es una fecha válida. *
* Devuelve 1 si es fecha válida, y 0 si no lo es *
**/

int fecha_valida(int dia, int mes, int anio) {

    int es_valida = 0;

    if(dia > 0 && mes > 0 && mes <= 12){

        if(dia <= 28){
            es_valida = 1;
        } else if (dia == 29){

            if (mes == 2 && es_bisiesto(anio) == 1){
                es_valida = 1;
            } else if (mes != 2){
                es_valida = 1;
            }

        } else if (dia == 30){
            if (mes != 2){
                es_valida = 1;
            }

        } else if (dia == 31){
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
                es_valida = 1;
            }
        }
    }

    return es_valida;
}

int main() {

    int dia, mes, anio, resultado, seguir;
    char continuar;

    seguir = 1;
    continuar = 'A';

    while(seguir == 1){

        printf("Ingrese tres números enteros para verificar si corresponden a una fecha válida. \n");

        printf("Ingrese primero el número que representa al día: \n");
        scanf("%i", &dia);

        printf("Ingrese el número que representa al mes: \n");
        scanf("%i", &mes);

        printf("Ingrese el número que representa al año: \n");
        scanf("%i", &anio);

        resultado = fecha_valida(dia, mes, anio);

        if(resultado == 0){
            printf("La fecha no es válida. \n");
        } else {
            printf("La fecha %i/%i/%i es válida. \n", dia, mes, anio);
        }

        printf("¿Desea verificar otra fecha? Ingrese Y para seguir o N para finalizar.\n");
        scanf(" %c", &continuar);

        if (continuar == 'N'){
            seguir = 0;
        }
    }

    return 0;
}
