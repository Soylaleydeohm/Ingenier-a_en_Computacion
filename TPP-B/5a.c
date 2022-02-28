#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define tamanio 10

void inicializar(int arr [], int size){
    int i;

    i = 0;

    srand (time(NULL)); //Inicializa el generador de números aleatorios

    while(i < size){
        arr[i++] = rand();
    }
    //checkpoint
}

void main(){
    int arr_num[tamanio];
    int i;

    i = 0;

    inicializar(arr_num, tamanio);
    //checkpoint

    while(i < tamanio){
        printf("arr_num[%d]: %d \n", i, arr_num[i++]);
    }
    return 0;
}
