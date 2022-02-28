#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "const.h"
#include "numero.h"
#include "matematica.h"

/**
   Muestra el número n.
**/

void mostrar_numero(tNumero n){
    printf("%s.%s\n", n->digitosEnteros, n->digitosFraccionarios);
}

/**
   Crea un nuevo número vacío, sin base ni dígitos.
   Referencia al mismo como *n
**/

 void crear_Numero(tNumero *n){

    //Reservo y chequeo la memoria.
    (*n) = (tNumero) malloc(sizeof(struct numero));

    //Reserva de memoria

    (*n)->digitosEnteros = (char*) malloc(sizeof(char) *10);
    (*n)->digitosFraccionarios = (char*) malloc(sizeof(char) *5);

    (*n)->base = malloc(sizeof(int));
    (*n)->cantEnteros = malloc(sizeof(int));
    (*n)->cantFraccionarios = malloc(sizeof(int));

     // Asigno los  valores
    *((*n)->base) = 0;
    *((*n)->cantEnteros) = 0;
    *((*n)->cantFraccionarios) = 0;
}

/**
   Crea un nuevo número resultado vacío, con la base indicada. Tiene un mayor tamaño de almacenamiento.
   Referencia al mismo como *n
**/

void crear_Numero_resultado(tNumero *n, int *baseD){

    int *i;
    int *j;

    //Reservo memoria.
    (*n) = (tNumero) malloc(sizeof(struct numero));
    i = malloc(sizeof(int));
    j = malloc(sizeof(int));

    //Reserva de memoria

    (*n)->digitosEnteros = (char*) malloc(sizeof(char)*41);
    (*n)->digitosFraccionarios = (char*) malloc(sizeof(char) *11);

    (*n)->base = malloc(sizeof(int));
    (*n)->cantEnteros = malloc(sizeof(int));
    (*n)->cantFraccionarios = malloc(sizeof(int));

     // Asigno los  valores
    *((*n)->base) = *baseD;
    *((*n)->cantEnteros) = 40;
    *((*n)->cantFraccionarios) = 10;

    *i = 0;

    while( (*i) < *((*n)->cantEnteros)){
        ((*n)->digitosEnteros)[*i] = '\0';
        (*i)++;
    }

    *j = 0;

    while( (*j) < *((*n)->cantFraccionarios)){
        ((*n)->digitosFraccionarios)[*j] = '\0';
        (*j)++;
    }


    free(i);
    free(j);

}

/**
   Se agrega un nuevo dígito c a la parte entera a continuación del último digito menos significativo.
**/
void insertar_Entero(tNumero n, char *c){
      //Recupero enteros inserto c en la última posición.
    (n->digitosEnteros)[*(n->cantEnteros)] = *c;
    (*(n->cantEnteros))++;
}

/**
   Se agrega un nuevo dígito c a la parte fraccionaria a continuación del último digito menos significativo.
**/
void insertar_Fraccionario(tNumero n, char *c){
      //Recupero fraccionario inserto c en la última posición.
     (n->digitosFraccionarios)[*(n->cantFraccionarios)]= *c;
     (*(n->cantFraccionarios))++;
}

/**
   Le asigna una base b al número n.
**/
void insertar_base(tNumero n, int *b){
    *(n->base) = *b;
}

/**
   Evalúa el caracter c y lo convierte a su correspondiente dígito en base 10.
**/
void evaluar_digito(char *c, int *digito){

    *digito = (int) *c;

    if((*digito >= 48) && (*digito <= 57)){
        *digito = *digito - 48;
    } else if ((*c) == 'a' || (*c) == 'A') {
        *digito = 10;
    } else if ((*c) == 'b' || (*c) == 'B') {
        *digito = 11;
    } else if ((*c) == 'c' || (*c) == 'C') {
        *digito = 12;
    } else if ((*c) == 'd' || (*c) == 'D') {
        *digito = 13;
    } else if ((*c) == 'e' || (*c) == 'E') {
        *digito = 14;
    } else if ((*c) == 'f' || (*c) == 'F') {
        *digito = 15;
    } else {
        printf("Hay un error en el ingreso de los argumentos.\n");
        exit(EXIT_FAILURE);
    }

}

/**
   Convierte al dígito en su correspondiente caracter en la nueva base.
**/

void convertir_digito_nbase(int *digito, char *c){
    //Si el dígito se encuentra entre 0 y 9
    if (*digito <= 9){
        *c = *digito + '0';

    //Si el "dígito" se encuentra entre 10 y 15 (A hasta E)
    } else if ((*digito) == 10) {
        *c = 'A';
    } else if ((*digito) == 11) {
        *c = 'B';
    } else if ((*digito) == 12) {
        *c = 'C';
    } else if ((*digito) == 13) {
        *c = 'D';
    } else if ((*digito) == 14) {
        *c = 'E';
    } else if ((*digito) == 15) {
        *c = 'F';
    }
}

/**
   Revisa que los dígitos del numero n pertenezcan a la base del mismo.
**/

void check_base(tNumero n, int *salida){

    int *i;
    int *j;
    int *digito;
    char *c;

    //Reserva de memoria
    i = malloc(sizeof(int));
    j = malloc(sizeof(int));
    digito = malloc(sizeof(int));
    c = malloc(sizeof(char));

    *salida = TRUE;
    *i = 0;
    *c=' ';
    //Chequeo digitos enteros.
    while((*salida == TRUE) && *i < *(n ->cantEnteros)){
        *c = n->digitosEnteros[*i];
        evaluar_digito(c, digito);
        if((*digito) >= *(n->base))
            *salida = FALSE;
        (*i)++;

    }

    *j = 0;

    //Chequeo digitos fraccionarios.
    while((*salida == TRUE) && *j < *(n ->cantFraccionarios)){
        *c = n->digitosFraccionarios[*j];
        evaluar_digito(c, digito);
        if((*digito) >= *(n->base))
            *salida = FALSE;
        (*j)++;
    }

    free(i);
    free(j);
    free(digito);
    free(c);
}

/**
   Libera la memoria reservada para el número n.
**/
void eliminar_Numero(tNumero *n){


     //Libero toda la memoria reservada por el número.
     free((*n)->digitosEnteros);
     free((*n)->digitosFraccionarios);
     free((*n)->base);
     free((*n)->cantEnteros);
     free((*n)->cantFraccionarios);
     free(*n);

}
