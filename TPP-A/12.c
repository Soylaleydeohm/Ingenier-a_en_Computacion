#include <string.h>

void misterio(char cadena[]){

        int tmpch, i, j;

        for (i = 0, j = strlen(cadena) - 1; i < j; i++, j--) {

            tmpch = cadena [i];
            cadena[i] = cadena[j];
            cadena[j] = tmpch;

        }
}
