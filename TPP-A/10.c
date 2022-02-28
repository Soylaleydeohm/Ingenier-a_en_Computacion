#include <stdio.h>
#include <stdlib.h>

/**
* Este programa lee una palabra y determina si es palíndroma. *
**/

int es_palindroma_cascara(char cadena [], int long_cadena, int posicion){

    int palindroma;

    palindroma = 1;

    //printf("Estamos comparando %c con %c\n", cadena[posicion], cadena[long_cadena - posicion - 1]);

    if (posicion < (long_cadena-1) /2){

        if (cadena[posicion] != cadena[long_cadena - posicion - 1]){
            palindroma = 0;
        } else {
            posicion++;
            palindroma = es_palindroma_cascara(cadena, long_cadena, posicion);
        }

    }

    return palindroma;

}

int es_palindroma (char cadena [], int long_cadena){

    int palindroma, pos;

    pos = 0;
    palindroma = 0;

    if (long_cadena == 1 || es_palindroma_cascara(cadena, long_cadena, pos) == 1){
        palindroma = 1;
    }

    return palindroma;
}


int main() {

    char cadena[100];
    char caracter;
    int i, contador, palindroma;

    i = 0;
    contador = 0;
    palindroma = 0;

    printf("Ingrese una secuencia de caracteres. \n");

    scanf("%c", &caracter); //Leo el primer caracter, que es el caso base.

    while(caracter != '\n'){

        //printf("El caracter actual es %c\n", caracter);

        if(caracter != ' '){

            cadena[i] = caracter;
            contador++;
            i++;
            scanf("%c", &caracter);

        } else {
            scanf("%c", &caracter);
            //printf("El número actual es %i\n", contador_aux);

        }
    }

    palindroma = es_palindroma(cadena, contador);

    if (palindroma == 0){
        printf("La secuencia %s no es palindroma", cadena);
    } else {
        printf("La secuencia %s es palindroma", cadena);
    }

    return 0;
}

