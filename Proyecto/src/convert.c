#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "const.h"
#include "numero.h"
#include "conversion.h"
#include "matematica.h"

/**
   Ayuda básica.
**/
void ayuda(){
    printf("Ayuda: \n");
    printf("-h imprime la ayuda.\n");
    printf("Para convertir un número de una base a otra debe asegurarse que su entrada respete el siguiente formato \n");
    printf("<numero a convertir> -b <base_origen> -d <base_destino> \n");
    printf("Si el número cuenta de una parte fraccionaria debe asegurarse de indicarla usando un punto o coma para separarla de la parte entera.\n");
    printf("En caso de no especificar una base  (de origen y/o destino) se supondrá que la misma es 10.\n");
    printf("-v imprime los cálculos realizados.\n");
}

/**
   Procedimiento que analiza la entrada de los argumentos.
**/

void entrada(char *ent[], tNumero n1, int *argumentos, int *verbose, int* baseDestino){

    char *c; //Caracter en la posición actual del cursor
    int *contadorArg; //Contador de argumentos.
    int *i; //Cursor en el arreglo.
    int *numeroValido; //Validez del número en la base indicada
    int *baseOrigen;

    //Variables necesarias para reescribir las bases enviadas por parámetro como *int
    unsigned long long int *pot;
    int *exp;
    int *basePotencia;

    //Reservo memoria
    contadorArg = malloc(sizeof(int));
    i = malloc(sizeof(int));
    numeroValido = malloc(sizeof(int));
    baseOrigen = malloc(sizeof(int));
    c = malloc(sizeof(char));
    pot = malloc(sizeof(unsigned long long));
    exp = malloc(sizeof(int));
    basePotencia = malloc(sizeof(int));

    //Dado que en *ent[0] se halla el nombre del programa, se analiza desde *ent[1] en adelante

    *contadorArg = 1;
    *baseOrigen = 0;
    *basePotencia = 10;

    while ((*contadorArg) < (*argumentos )){
        //Lee el contenido del arreglo
        *i = 0;

        if((ent[*contadorArg][0]) == '-'){
            if(ent[*contadorArg][1] == 'v'){
                *verbose = 1;
                (*contadorArg)++;
            }else if (ent[*contadorArg][1] == 'h'){
                ayuda();
                (*contadorArg)++;
            }else if (ent[*contadorArg][1] == 'n'){
                (*contadorArg)++;
                if(ent[*contadorArg][0] != '\0') {
                    while (ent[*contadorArg][*i] != '.' && ent[*contadorArg][*i] != ',' && ent[*contadorArg][*i] != '\0'){
                        insertar_Entero(n1, &ent[*contadorArg][*i]);
                        (*i)++;
                        if (*(n1->cantEnteros) >10){
                            printf("El número entero debe tener máximo 10 dígitos.\n");
                            exit(EXIT_FAILURE);
                        }
                    } if (ent[*contadorArg][*i] == '.' || ent[*contadorArg][*i] == ','){
                        (*i)++;
                        if (ent[*contadorArg][*i] != '\0'){
                            while(ent[*contadorArg][*i] != '\0') {
                                insertar_Fraccionario(n1, &ent[*contadorArg][*i]);
                                (*i)++;
                            }
                            if (*(n1->cantFraccionarios) >5){
                            printf("El número fraccionario debe tener máximo 5 dígitos.\n");
                            exit(EXIT_FAILURE);
                        }
                        }
                    } if (ent[*contadorArg][*i] == '\0'){
                        (*contadorArg)++;
                        *i = 0;
                    }
                }else{
                    printf("Hay un error en el ingreso de los argumentos.\n");
                    exit(EXIT_FAILURE);
                }
            }else if (ent[*contadorArg][1] == 's'){
                (*contadorArg)++;
                ent[*contadorArg] = ent[*contadorArg];
                if(ent[*contadorArg][0] != '\0') {
                    *pot = 0;
                    while(ent[*contadorArg][*i] != '\0') {
                        *exp = *i;
                        potencia(basePotencia, exp, pot);
                        *baseOrigen = (((int) (ent[*contadorArg][*i]))- 48) + (*baseOrigen) * (*pot);
                        (*i)++;
                    }
                    (*contadorArg)++;
                    if (*baseOrigen > 16 || *baseOrigen < 2){
                        printf("La base origen no se encuentra en el rango de representación del programa.\n");
                        exit(EXIT_FAILURE);
                    }
                }else{
                    printf("Hay un error en el ingreso de los argumentos.\n");
                    exit(EXIT_FAILURE);
                }
            *i = 0;
            }else if (ent[*contadorArg][1] == 'd'){
                (*contadorArg)++;
                if(ent[*contadorArg][0] != '\0') {
                    *pot = 0;
                    while(ent[*contadorArg][*i] != '\0') {
                        *exp = *i;
                        potencia(basePotencia, exp, pot);
                        *baseDestino = (((int) (ent[*contadorArg][*i]))- 48) + (*baseDestino) * (*pot);
                        (*i)++;
                    }
                    (*contadorArg)++;
                    if (*baseDestino > 16 || *baseDestino < 2){
                        printf("La base destino no se encuentra en el rango de representación del programa.\n");
                        exit(EXIT_FAILURE);
                    }
                }else{
                    printf("Hay un error en el ingreso de los argumentos.\n");
                    exit(EXIT_FAILURE);
                }
            *i = 0;
            }
        } else{
            printf("Hay un error en el ingreso de los argumentos.\n");
            exit(EXIT_FAILURE);
        }
    }

     //En caso que no se especifiquen las bases de origen y o destino se supondrá que son 10.
    if(*(baseOrigen) == 0){
        *(n1->base) = 10;
    } else {
        *(n1->base) = *(baseOrigen);
    }
    if(*(baseDestino) == 0){
        *baseDestino = 10;
    }

    check_base(n1, numeroValido);
    if (*numeroValido == 0){
        printf("El número no se encuentra en la base de origen indicada.\n");
        exit(EXIT_FAILURE);
    }

    //Libero memoria almacenada
    free(contadorArg);
    free(i);
    free(baseOrigen);
    free(numeroValido);
    free(c);
    free(pot);
    free(exp);
    free(basePotencia);

}

int main(int argc, char * argN[]){

    int *cantArgumentos;
    int *verbose;
    int *baseDestino;
    tNumero n1;
    tNumero result;

    cantArgumentos = malloc(sizeof(int));
    verbose = malloc(sizeof(int));
    baseDestino = malloc(sizeof(int));

    printf("Conversor de números: desde la base 2 a la base 16.\n");

    crear_Numero(&n1);

    *cantArgumentos = argc;
    *verbose = 0;
    entrada(argN, n1, cantArgumentos, verbose, baseDestino);

    if (*(n1 ->cantFraccionarios) > 0 || *(n1 ->cantEnteros) > 0){
        printf("Número ingresado: ");
        mostrar_numero(n1);
        printf("\n");

        crear_Numero_resultado(&result, baseDestino);

        transformar(n1, result, verbose);

        eliminar_Numero(&result);
    }


    free(cantArgumentos);
    free(verbose);
    free(baseDestino);

    eliminar_Numero(&n1);


    exit(EXIT_SUCCESS);
}











