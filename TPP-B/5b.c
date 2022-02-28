#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define tamanio 10

void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

// A function to implement bubble sort
void sort(int arr[], int n)
{
   int i, j;
   for (i = 0; i < n-1; i++)

       // Last i elements are already in place
       for (j = 0; j < n-i-1; j++)
           if (arr[j] > arr[j+1])
              swap(&arr[j], &arr[j+1]);
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

    inicializar(arr_num, tamanio);
    //checkpoint

    printf("Arreglo: \n");
    printArray(arr_num, tamanio);

    sort(arr_num, tamanio);
    //checkpoint

    printf("Arreglo ordenado: \n");
    printArray(arr_num, tamanio);

    return 0;
}
