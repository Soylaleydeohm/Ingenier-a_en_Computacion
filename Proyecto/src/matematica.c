#include <stdio.h>
#include <stdlib.h>

/**
   Calcula la potencia de un número n elevado al exponente natural exp. result almacena el resultado.
**/

extern void potencia (int *n, int *exp, unsigned long long int *result){
    if ((*exp) == 0){
        *result = 1;
    }
    else{
        *exp = *exp - 1;
        potencia(n, exp , result);
        *result = (*result) * (*n);
    }
}
