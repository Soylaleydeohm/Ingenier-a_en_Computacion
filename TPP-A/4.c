#include <stdio.h>
#include <stdlib.h>

/**
* Este programa lee n números enteros largos, y muestra por pantalla el mayor, el menor y el promedio de la serie ingresada. *
**/

int main() {

    long int actual;
    int cantidad, mayor, menor, prom_aux;
    float promedio;
    char caracter;
    int aux;
    int contador_aux;

    cantidad = 0;
    promedio = 0;
    prom_aux = 0;
    contador_aux = 0;
    aux = 0;

    printf("Ingrese un número entero por renglón. Cuando desee terminar de ingresar números, ingrese '.'. \n");

    scanf("%c", &caracter); //Leo el primer caracter, que es el caso baso.

    while(caracter != '.'){

        //printf("El caracter actual es %c\n", caracter);

        if(caracter != ' ' && caracter != '\n'){

            aux = caracter - '0';
            contador_aux = contador_aux * 10 + aux;
            scanf("%c", &caracter);

        } else {

            //printf("El número actual es %i\n", contador_aux);
            actual = contador_aux;
            contador_aux = 0;
            scanf("%c", &caracter);
            cantidad++;

            if(cantidad == 1){
                mayor = actual;
                menor = actual;

            } else {

                if (mayor < actual)
                    mayor = actual;
                if (menor > actual)
                    menor = actual;
            }
            prom_aux += actual;
        }
    }

    promedio = (float) prom_aux / cantidad;

    printf("Resultado: Mayor de la serie: %li; \n Menor de la serie: %li; \n Promedio de la serie: %0.2f\n", mayor, menor, promedio);

    return 0;
}

