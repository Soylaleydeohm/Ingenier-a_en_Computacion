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


void intercalar(int arr[], int arr1[], int arr2[], int n)
{
   int i, j, k;
   i = 0;
   j = 0;
   k = 0;

   while (i < n){
        while (j < n){
            //printf("i: %d; j: %d \n", i,j);
            if (arr1[j] > arr2 [i]){
              //  printf("arr1 [ %d]: %d > arr2 [ %d]: %d \n", j, arr1[j],i,arr2[i]);
                arr[k] = arr2[i];
                printf("arr [ %d]: %d \n", k,arr[k]);
                i++;
            } else if (arr1[j] < arr2 [i]){
                //printf("arr1 [ %d]: %d < arr2 [ %d]: %d \n", j, arr1[j],i,arr2[i]);
                arr[k] = arr1[j];
                printf("arr [ %d]: %d \n", k,arr[k]);
                j++;
            } else {
                //printf("arr1 [ %d]: %d = arr2 [ %d]: %d \n", j, arr1[j],i,arr2[i]);
                arr[k] = arr1[j];
                printf("arr [ %d]: %d \n", k,arr[k]);
                j++;
                i++;
            }
            k++;
        }
   }
   while (i < n){
        arr[k] = arr2[i];
        printf("arr [ %d]: %d \n", k,arr[k]);
        i++;
        k++;
    }
    while (j < n){
        arr[k] = arr2[j];
        printf("arr [ %d]: %d \n", k,arr[k]);
        j++;
        k++;
    }
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

    while(i < size){
        arr[i++] = rand();
    }
    //checkpoint
}

void main(){
    int arr_1[tamanio];
    int arr_2[tamanio];
    int arr[sizeof(arr_1)/sizeof(arr_1[0]) + sizeof(arr_2)/sizeof(arr_2[0])];
    int tam, tam2;

    tam = sizeof(arr_1)/sizeof(arr_1[0]) + sizeof(arr_2)/sizeof(arr_2[0]);
    tam2 = sizeof(arr)/sizeof(arr[0]);
    printf("tam: %d \n", tam);
    printf("tam2: %d \n", tam2);

    srand (time(NULL)); //Inicializa el generador de números aleatorios

    inicializar(arr_1, tamanio);
    inicializar(arr_2, tamanio);
    //checkpoint

    sort(arr_1, tamanio);
    sort(arr_2, tamanio);

    printf("Arreglo 1: \n");
    printArray(arr_1, tamanio);
    printf("Arreglo 2: \n");
    printArray(arr_2, tamanio);

    intercalar(arr, arr_1, arr_2, tamanio);
    //checkpoint

    printf("Arreglo ordenado: \n");
    printArray(arr, sizeof(arr)/sizeof(arr[0]));

    return 0;
}
