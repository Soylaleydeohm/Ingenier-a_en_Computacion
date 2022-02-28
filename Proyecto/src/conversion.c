#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "const.h"
#include "numero.h"
#include "conversion.h"
#include "matematica.h"

/**
   Utiliza al método de la división para convertir la parte entera de un número origen en base 10 a otra base. result almacena el resultado. verbose indica si se presentan o no los cálculos en detalle.
**/

void tEntero_div (tNumero origen, tNumero result, int *verbose){

    int *i;
    int *j;
    int *k;
    int *enteroAux;
    int *digito;
    unsigned long long int *cociente;
    unsigned long long int *numeroOriginal;
    int *restoAux;
    char *convertidoInverso;
    char *aux;

    //Reserva de memoria

    i = malloc(sizeof(int));
    j = malloc(sizeof(int));
    k = malloc(sizeof(int));
    enteroAux = malloc(sizeof(int));
    digito = malloc(sizeof(int));
    cociente = malloc(sizeof(unsigned long long));
    numeroOriginal = malloc(sizeof(unsigned long long));
    restoAux = malloc(sizeof(int));

    convertidoInverso = (char*) malloc(sizeof(char) *40);
    aux = (char*) malloc(sizeof(char) *2);

    //Se convierte char *digitosEnteros a un puntero a un número entero para poder realizar la operación división.

    *numeroOriginal = 0;

    mostrar_numero(origen);

    for(*i = 0; (*i < *(origen->cantEnteros) && ((origen->digitosEnteros)[*i]!= '\0')) ; (*i)++){
        *enteroAux = (origen->digitosEnteros)[*i] - '0';
        *numeroOriginal = ((*numeroOriginal) * 10) + (*enteroAux);
    }

    //Se almacenan los restos de dividir al número por la base y sus respectivos cocientes, hasta que el cociente es menor a la base.
    *cociente = *numeroOriginal;
    *j = 0;

    if ((*verbose) == 1){
        printf("A continuación se muestran los cálculos de la conversión de la parte entera del número %llu en base 10 a base %d con el método de la división.\n", *numeroOriginal, *(result->base));
    }

    *digito = 0;

    if (*cociente < *(result->base)){
        *digito = (int) *cociente;
        convertir_digito_nbase(digito, aux);
        convertidoInverso[*j] = *aux;
        (*j)++;
    } else {
        while (*cociente >= *(result->base)){
            *restoAux = (*cociente) % (*(result->base));
            convertir_digito_nbase(restoAux, aux);
            convertidoInverso[*j] = *aux;
            if ((*verbose) == 1){
                printf("%llu / %d = %llu, resto %c\n", *cociente, *(result->base), ((*cociente) / (*(result->base))), convertidoInverso[*j]);
            }
            *cociente = (*cociente) / (*(result->base));
            (*j)++;
            if (*cociente < *(result->base)){
                *digito = (int) *cociente;
                convertir_digito_nbase(digito, aux);
                convertidoInverso[*j] = *aux;
                if ((*j) > 40){
                    printf("El número resultado no se puede representar en la base solicitada con este conversor.\n");
                    exit(EXIT_FAILURE);
                }
                if ((*verbose) == 1){
                    printf("%llu / %d = %llu, resto %c\n", *cociente, *(result->base), ((*cociente) / (*(result->base))), convertidoInverso[*j]);
                    printf("Finaliza la operación.\n");
                }
                (*j)++;
            }
        }
    }

    // Ordeno el puntero al arreglo anterior almacenándolo en el puntero al resultado.
    *k = 0;

    if((*j) == 0){
        (result->digitosEnteros)[*k] = '0';
        (*k)++;
    } else {
        while (*j > 0){
            (*j)--;
            (result->digitosEnteros)[*k] = convertidoInverso[*j];
            (*k)++;
        }
    }

    (result->digitosEnteros)[*k] ='\0';

    if ((*verbose) == 1){
        printf("\n");
        printf("Parte entera en base %d: %s\n", *(result->base), result->digitosEnteros);
        printf("\n");
    }

    //Liberar memoria reservada
    free(i);
    free(j);
    free(k);
    free(enteroAux);
    free(digito);
    free(cociente);
    free(numeroOriginal);
    free(restoAux);
    free(convertidoInverso);
    free(aux);
}

/**
   Utiliza al método de la multiplicación para convertir la parte fraccionaria de un número origen en base 10 a otra base. result almacena el resultado. verbose indica si se presentan o no los cálculos en detalle.
**/

void tFraccionario_mult (tNumero origen, tNumero result, int *verbose){

    int *i;
    int *j;
    int *fraccAux;
    int *funcionPiso;
    double *numeroOriginal;
    double *parteFrac;
    char *aux;

    //Reserva de memoria

    i = malloc(sizeof(int));
    j = malloc(sizeof(int));
    fraccAux = malloc(sizeof(int));
    funcionPiso = malloc(sizeof(int));

    numeroOriginal = malloc(sizeof(double));
    parteFrac = malloc(sizeof(double));

    aux = (char*) malloc(sizeof(char) *2);

    //Se inicializa el fraccionario en cero
    *numeroOriginal = 0;

    for(*i = *(origen->cantFraccionarios); *i > 0; (*i)--){
        *fraccAux = (origen->digitosFraccionarios)[(*i)-1] - '0';
        *numeroOriginal = ((*numeroOriginal) + *fraccAux)* 0.1;
    }


    //Se almacenan la parte fraccionaria luego de restar la función techo del paso anterior, con la cantidad de decimales asignada por diseño.
    *parteFrac = *numeroOriginal;
    *j = 0;

    if ((*verbose) == 1){
        printf("A continuación se muestran los cálculos de la conversión de la parte fraccionaria del número %0.10f en base 10 a base %d con el método de la multiplicación.\n", *numeroOriginal, *(result->base));
    }

    while (*j < *(result->cantFraccionarios)){
        *funcionPiso = (*parteFrac) * (*(result->base));
        if ((*verbose) == 1){
            printf("|_%0.10f * %d_|= |_%0.10f_|= %d\n", *parteFrac, *(result->base),((*parteFrac) * (*(result->base))), *funcionPiso);
        }
        convertir_digito_nbase(funcionPiso, aux);
        (result->digitosFraccionarios)[*j] = *aux;
        *parteFrac = ((*parteFrac) * (*(result->base))) - *funcionPiso;
        (*j)++;
        if (*j == *(result->cantFraccionarios)){
            (result->digitosFraccionarios)[*j] = '\0';
            if ((*verbose) == 1){
                printf("Fin de la operación.\n");
            }
        }
    }

    if ((*verbose) == 1){
        printf("\n");
        printf("Parte fraccionaria en base %d: 0.%s\n", *(result->base), result->digitosFraccionarios);
        printf("\n");
    }


    //Liberar memoria reservada
    free(i);
    free(j);
    free(fraccAux);
    free(funcionPiso);
    free(numeroOriginal);
    free(parteFrac);

}

/**
   Utiliza al método de la multiplicación para convertir la parte entera de un número origen en una base a base 10. esult almacena el resultado. verbose indica si se presentan o no los cálculos en detalle.
**/

void tEntero_mult (tNumero origen, tNumero result, int *verbose){

    int *i;
    int *j;
    int *enteroAux;
    unsigned long long int *sumaParcial;
    unsigned long long int *pot;
    unsigned long long int *auxlongint;
    int *exp;
    char *aux;

    //Reserva de memoria

    i = malloc(sizeof(int));
    j = malloc(sizeof(int));
    enteroAux = malloc(sizeof(int));
    sumaParcial = malloc(sizeof(unsigned long long));
    pot = malloc(sizeof(unsigned long long));
    auxlongint = malloc(sizeof(unsigned long long));
    exp = malloc(sizeof(int));

    aux = (char*) malloc(sizeof(char) *2);

    //Se multiplica a cada dígito por la base elevada a la posición (se considera cero la posición menos significativa).

    *sumaParcial = 0;// Agregar numeroOriginal

    if ((*verbose) == 1){
        printf("A continuación se muestran los cálculos de la conversión de la parte entera del número %s en base %d a base 10 con el método de la multiplicación.\n", origen->digitosEnteros, *(origen->base));
    }

    for(*i = 0; *i < *(origen->cantEnteros); (*i)++){
        evaluar_digito(&(origen->digitosEnteros)[*i], enteroAux); //Se convierte los caracteres en números, teniendo el ciudado de convertir correctamente desde A hasta F.
        if ((*sumaParcial) ==  ULONG_MAX || (*sumaParcial) < 0){
            printf("El número resultado no se puede representar en la base solicitada con este conversor.\n");
            exit(EXIT_FAILURE);
        }
        if ((*verbose) == 1){
            printf("(%d + %llu) * %d = %llu, siendo %llu el resultado de la suma parcial hasta la iteración anterior\n", *enteroAux, *sumaParcial, *(origen->base), (((*sumaParcial) * (*(origen->base))) + *enteroAux), *sumaParcial);
        }
        *sumaParcial = ((*sumaParcial) * (*(origen->base))) + *enteroAux;

    }
    if (*i == *(origen->cantEnteros) && (*verbose) == 1){
        printf("Fin de la operación.\n");
        printf("\n");
        printf("La parte entera del número %s en base %d a base 10 es %llu\n", origen->digitosEnteros, *(origen->base), *sumaParcial);
        printf("\n");
    }

    // Se almacena el valor obtenido en el puntero al tNumero resultado.

    *j = 0;
    (*i)++;

    if((*sumaParcial) == 0){
        (result->digitosEnteros)[*j] = '0';
        (*j)++;
    } else {
        while (*sumaParcial > 0){
            *exp = *i;
            potencia((result->base), exp, pot);
            *auxlongint = ((*sumaParcial)/(*pot));
            *aux =  (*auxlongint )+ '0';
            (result->digitosEnteros)[*j] = *aux;
            *sumaParcial = *sumaParcial - ((*sumaParcial)/(*pot))*(*pot);
            (*j)++;
            (*i)--;
        }
    }


    (result->digitosEnteros)[*j] = '\0';

    //Liberar memoria reservada
    free(i);
    free(j);
    free(enteroAux);
    free(sumaParcial);
    free(pot);
    free(exp);
    free(aux);

}

/**
   Utiliza al método de la división para convertir la parte fraccionaria de un número origen en una base a base 10. result almacena el resultado. verbose indica si se presentan o no los cálculos en detalle.
**/

void tFraccionario_div (tNumero origen, tNumero result, int *verbose){

    int *i;
    int *j;
    int *digitoAux;
    int *numeroAux;
    double *fraccAux;
    double *cociente;
    char *aux;

    //Reserva de memoria

    i = malloc(sizeof(int));
    j = malloc(sizeof(int));
    digitoAux = malloc(sizeof(int));
    numeroAux = malloc(sizeof(int));

    fraccAux = malloc(sizeof(double));
    cociente = malloc(sizeof(double));

    aux = (char*) malloc(sizeof(char) *2);

    //Se divide a cada suma parcial por la base de origen, y ese valor se suma al siguiente dígito más significativo (comenzando por el menos significativo).

    *cociente = 0;// Agregar numeroOriginal

    if ((*verbose) == 1){
        printf("A continuación se muestran los cálculos de la conversión de la parte fraccionaria del número 0.%s en base %d a base 10 con el método de la división.\n", origen->digitosFraccionarios, *(origen->base));
    }

    for(*i = *(origen->cantFraccionarios)-1; *i >= 0; (*i)--){
        evaluar_digito(&(origen->digitosFraccionarios)[*i], digitoAux); //Se convierte los caracteres en números, teniendo el ciudado de convertir correctamente desde A hasta F.
        *fraccAux = (*digitoAux);
        if ((*verbose) == 1){
            printf("(%d + %0.10f) L %d = %0.10f, siendo %0.10f el cociente de la iteración anterior\n", *digitoAux, *cociente, *(origen->base), ((*cociente) + (*digitoAux))/(*(origen->base)), *cociente);
        }
        *cociente = ((*cociente) + (*digitoAux))/(*(origen->base));
        if (*i == 0 && (*verbose) == 1){
                printf("Fin de la operación.\n");
            }
    }

    // Se almacena el valor obtenido en el puntero al tNumero resultado.

    *j = 0;
    while (*j < *(result->cantFraccionarios)){
        *numeroAux = (*cociente)*10;
    //printf("%d\n", *numeroAux);
        *aux = *numeroAux  + '0';
        (result->digitosFraccionarios)[*j] = *aux;
        *cociente = ((*cociente)*10-(*numeroAux));
        (*j)++;
    }
    if (*j == *(result->cantFraccionarios)){
        (result->digitosFraccionarios)[*j] = '\0';
    }

    if ((*verbose) == 1){
        printf("\n");
        printf("Parte fraccionaria en base %d: %s\n", *(result->base), result->digitosFraccionarios);
        printf("\n");
    }

  //  *(result->cantEnteros) = *(origen->cantFraccionarios); //Revisar

    //Liberar memoria reservada
    free(i);
    free(j);
    free(digitoAux);
    free(numeroAux);
    free(fraccAux);
    free(cociente);
    free(aux);

}

/**
   Transforma al número num a la base 10 desde la base original. result almacena el resultado. verbose indica si se presentan o no los cálculos en detalle.
**/

void transformar_a_b10 (tNumero num, tNumero result, int *verbose){

    tEntero_mult(num, result, verbose);
    tFraccionario_div(num, result, verbose);

}

/**
   Transforma al número num a la base 10 desde la base original.result almacena el resultado. verbose indica si se presentan o no los cálculos en detalle.
**/

void transformar_desde_b10 (tNumero num, tNumero result, int *verbose){

    tEntero_div(num, result, verbose);
    tFraccionario_mult(num, result, verbose);

}

/**
   Transforma al número num desde su base origen a la base destino. result almacena el resultado. verbose indica si se presentan o no los cálculos en detalle.
**/

void transformar(tNumero num, tNumero result, int *verbose){

    //Variable necesaria en caso de realizar conversiones desde y hacia bases distintas de 10.
    tNumero resultAux;
    int *base10;

    //Reserva de memoria
    base10 = malloc(sizeof(int));

    if(*(result->base) == *(num->base)){

        printf("El número ya se encuentra en la base destino: (%s.%s)_b%d\n", num->digitosEnteros, num->digitosFraccionarios, *(num->base));

    } else if(*(result->base) == 10){

        if (*(num->cantEnteros)> 0 && *(num->cantFraccionarios)> 0){
            transformar_a_b10(num, result, verbose);
            printf("El número (%s.%s)_b%d en base %d es (%s.%s)_b%d\n", num->digitosEnteros, num->digitosFraccionarios, *(num->base), *(result->base), result->digitosEnteros, result->digitosFraccionarios, *(result->base));
        } else if (*(num->cantEnteros)> 0){
            tEntero_mult(num, result, verbose);
            printf("El número (%s.0)_b%d en base %d es (%s.0)_b%d\n", num->digitosEnteros, *(num->base), *(result->base), result->digitosEnteros,  *(result->base));
        } else {
            tFraccionario_div(num, result, verbose);
            printf("El número (0.%s)_b%d en base %d es (0.%s)_b%d\n",  num->digitosFraccionarios, *(num->base), *(result->base),  result->digitosFraccionarios, *(result->base));
        }

    } else  if(*(num->base) == 10){

        if (*(num->cantEnteros)> 0 && *(num->cantFraccionarios)> 0){
            transformar_desde_b10(num, result, verbose);
            printf("El número (%s.%s)_b%d en base %d es (%s.%s)_b%d\n", num->digitosEnteros, num->digitosFraccionarios, *(num->base), *(result->base), result->digitosEnteros, result->digitosFraccionarios, *(result->base));
        } else if (*(num->cantEnteros)> 0){
            tEntero_div(num, result, verbose);
            printf("El número (%s.0)_b%d en base %d es (%s.0)_b%d\n", num->digitosEnteros, *(num->base), *(result->base), result->digitosEnteros,  *(result->base));
        } else {
            tFraccionario_mult(num, result, verbose);
            printf("El número (0.%s)_b%d en base %d es (0.%s)_b%d\n",  num->digitosFraccionarios, *(num->base), *(result->base),  result->digitosFraccionarios, *(result->base));
        }

    } else {

        *base10 = 10;
        crear_Numero_resultado(&resultAux, base10);
        if (*(num->cantEnteros)> 0 && *(num->cantFraccionarios)> 0){
            transformar_a_b10(num, resultAux, verbose);
            transformar_desde_b10(resultAux, result, verbose);
            printf("El número (%s.%s)_b%d en base %d es (%s.%s)_b%d\n", num->digitosEnteros, num->digitosFraccionarios, *(num->base), *(result->base), result->digitosEnteros, result->digitosFraccionarios, *(result->base));
        } else if (*(num->cantEnteros)> 0){
            tEntero_mult(num, resultAux, verbose);
            tEntero_div(resultAux, result, verbose);
            printf("El número (%s.0)_b%d en base %d es (%s.0)_b%d\n", num->digitosEnteros, *(num->base), *(result->base), result->digitosEnteros,  *(result->base));
        } else {
            tFraccionario_div(num, resultAux, verbose);
            tFraccionario_mult(resultAux, result, verbose);
            printf("El número (0.%s)_b%d en base %d es (0.%s)_b%d\n",  num->digitosFraccionarios, *(num->base), *(result->base),  result->digitosFraccionarios, *(result->base));
        }
        eliminar_Numero(&resultAux);
    }

    //Libera memoria
    free(base10);

}
