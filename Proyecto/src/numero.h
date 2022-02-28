
/**
   Estructura para la manipulación de números.
   Cada número es representado con su parte entera, su parte fraccionaria, su cantidad de dígitos enteros y fraccionarios, y su base.
**/
typedef struct numero{

// Diez dígitos de parte entera, una coma y cinco digítos para la parte fraccionaria.
char *digitosEnteros ;
char *digitosFraccionarios;
int *cantEnteros;
int *cantFraccionarios;
int *base;

}* tNumero;

/**
   Crea un nuevo número vacío, sin base ni dígitos.
   Referencia al mismo como *n
**/
extern void crear_Numero(tNumero *n);

/**
   Crea un nuevo número resultado vacío, con la base indicada. Tiene un mayor tamaño de almacenamiento.
   Referencia al mismo como *n
**/
extern void crear_Numero_resultado(tNumero *n, int *base);

/**
   Se agrega un nuevo dígito c a la parte entera a continuación del útimo digito menos significativo.
**/
extern void insertar_Entero(tNumero n, char *c);

/**
   Se agrega un nuevo dígito c a la parte fraccionaria a continuación del útimo digito menos significativo.
**/
extern void insertar_Fraccionario(tNumero n, char *c);

/**
   Le asigna una base b al número n.
**/
extern void insertar_base(tNumero n, int *b);

/**
   Revisa que los dígitos del numero n pertenezcan a la base del mismo.
**/
extern void check_base(tNumero n, int *salida);

/**
   Evalúa el caracter c y lo convierte a su correspondiente dígito en base 10.
**/
extern void evaluar_digito(char *c, int *digit);

/**
   Convierte al dígito en su correspondiente caracter en la nueva base.
**/
extern void convertir_digito_nbase(int *digit, char *c);

/**
   Muestra el número n.
**/
extern void mostrar_numero(tNumero n);

/**
   Libera la memoria reservada para el número n.
**/
extern void eliminar_Numero(tNumero *n);




