#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define tamanio 3

// A function to implement bubble sort
int esta_ordenado(int arr[], int n)
{
   int i, j, ordenado;

   ordenado = 1;

   for (i = 0; i < n-1; i++)
        if (arr[i] > arr[i+1])
            ordenado = 0;

    return ordenado;
}

/* Function to print an array */
void printArray(int arr[], int size)
{
    int i;
    for (i=0; i < size; i++)
        printf("%d \n", arr[i]);
    printf("\n");
}

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
    int ordenado;

    inicializar(arr_num, tamanio);
    //checkpoint

    printf("Arreglo: \n");
    printArray(arr_num, tamanio);

    ordenado = esta_ordenado(arr_num, tamanio);
    //checkpoint

    if (ordenado == 0)
        printf("Arreglo ordenado: No. \n");
    else
    printf("Arreglo ordenado: Sí. \n");

    return 0;
}

