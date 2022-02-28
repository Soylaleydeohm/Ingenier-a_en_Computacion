#include <stdio.h>
#include <stdlib.h>

/**
* Este programa lee un número entero en base decimal y cuenta la cantidad de veces que aparece un dígito dado. *
**/

int pos_par(int num);

int pos_impar (int num){

    int digitos;

    digitos = 0;

    if (num < 10 && num % 2 == 0){
        digitos = 1;
    }
    else if (num % 2 == 0){
        digitos = pos_par(num/10) + 1;
    }

    else if (num % 2 != 0){
        digitos = pos_par(num/10);
    }

    //printf("Dígitos impares %i\n", digitos);

    return digitos;

}

int pos_par(int num){

    int digitos;

    digitos = 0;

    //printf("Número %i\n", num);

    if (num > 9){
        digitos = pos_impar(num/10);
    }

    //printf("Dígitos pares %i\n", digitos);

    return digitos;

}

//int invertir (int num){
//
//    int aux, inverso;
//
//    aux = 0;
//    inverso = 0;
//
//    printf("Num ingresado %i\n", num);
//
//    printf("digito %i\n", num % 10);
//
//    if (num < 10){
//        inverso = num + inverso;
//    }
//    else{
//        aux = (num % 10 + inverso)*10;
//        printf("aux %i\n", aux);
//        printf("Inverso %i\n", inverso);
//        inverso = aux + invertir(num/10);
//        printf("Inverso %i\n", inverso);
//    }
//
//        printf("Inverso %i\n", inverso);
//
//    return inverso;
//}

int invertir (int num){

    int resto, inverso;
    inverso = 0;
    while (num != 0){

        resto = num % 10;
        num = num/10;
        inverso = inverso*10 + resto;
    }

    return inverso;
}

int main() {

    int numero, digitos;

    digitos = 0;

    printf("Ingrese un número entero en base decimal. \n");

    scanf("%i", &numero);

    digitos = pos_par(invertir(numero));

    printf("La cantidad de dígitos pares que ocupan posiciones impares en el número %i es igual a %i.\n", numero, digitos);

    return 0;
}
