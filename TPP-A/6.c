#include <stdio.h>
#include <stdlib.h>

/**
* Este programa lee un número entero en notación hexadecimal y lo convierte en su equivalente en base decimal. *
**/


int main() {

    int n_decimal, aux, i;
    char lector_hexa;
    char n_hexa [100];

    n_decimal = 0;
    aux = 0;
    i = 0;

    printf("Ingrese un número entero en notación hexadecimal. \n");

    scanf("%c", &lector_hexa);

    while(lector_hexa != '\n'){

        n_hexa [i] = lector_hexa;
        i++;

        //printf("El caracter actual es %c\n", lector_hexa);

        if(lector_hexa == 'a' || lector_hexa == 'A'){
            aux = 10;
            n_decimal = n_decimal * 16 + aux;
            //printf("Contador aux es %i\n", n_decimal);
            scanf("%c", &lector_hexa);
        }

        else if(lector_hexa == 'b' || lector_hexa == 'B'){
            aux = 11;
            n_decimal = n_decimal * 16 + aux;
            //printf("Contador aux es %i\n", n_decimal);
            scanf("%c", &lector_hexa);
        }

        else if(lector_hexa == 'c' || lector_hexa == 'C'){
            aux = 12;
            n_decimal = n_decimal * 16 + aux;
            //printf("Contador aux es %i\n", n_decimal);
            scanf("%c", &lector_hexa);
        }

        else if(lector_hexa == 'd' || lector_hexa == 'D'){
            aux = 13;
            n_decimal = n_decimal * 16 + aux;
            //printf("Contador aux es %i\n", n_decimal);
            scanf("%c", &lector_hexa);
        }

        else if(lector_hexa == 'e' || lector_hexa == 'E'){
            aux = 14;
            n_decimal = n_decimal * 16 + aux;
            //printf("Contador aux es %i\n", n_decimal);
            scanf("%c", &lector_hexa);
        }

        else if(lector_hexa == 'f' || lector_hexa == 'F'){
            aux = 15;
            n_decimal = n_decimal * 16 + aux;
            //printf("Contador aux es %i\n", n_decimal);
            scanf("%c", &lector_hexa);
        }

        else {
            aux = lector_hexa - '0';
            n_decimal = n_decimal * 16 + aux;
            //printf("Contador aux es %i\n", n_decimal);
            scanf("%c", &lector_hexa);
        }
    }

    printf("El número %s en notación hexadecimal, es equivalente al número %i en base decimal.\n", n_hexa, n_decimal);

    return 0;
}
