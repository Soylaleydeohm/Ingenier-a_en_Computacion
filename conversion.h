/**
   Utiliza al método de la división para convertir la parte entera de un número origen en base 10 a otra base. result almacena el resultado. verbose indica si se presentan o no los cálculos en detalle.
**/
extern void tEntero_div (tNumero origen, tNumero result, int *verbose);

/**
   Utiliza al método de la multiplicación para convertir la parte fraccionaria de un número origen en base 10 a otra base. result almacena el resultado. verbose indica si se presentan o no los cálculos en detalle.
**/
extern void tFraccionario_mult (tNumero origen, tNumero result, int *verbose);

/**
   Utiliza al método de la multiplicación para convertir la parte entera de un número origen en una base a base 10. result almacena el resultado. verbose indica si se presentan o no los cálculos en detalle.
**/
extern void tEntero_mult (tNumero origen, tNumero result, int *verbose);

/**
   Utiliza al método de la división para convertir la parte fraccionaria de un número origen en una base a base 10. result almacena el resultado. verbose indica si se presentan o no los cálculos en detalle.
**/
extern void tFraccionario_div (tNumero origen, tNumero result, int *verbose);

/**
   Transforma al número num desde la base 10 a la nueva base. result almacena el resultado. verbose indica si se presentan o no los cálculos en detalle.
**/
extern void transformar_desde_b10 (tNumero num, tNumero result, int *verbose);

/**
   Transforma al número num a la base 10 desde la base original.result almacena el resultado. verbose indica si se presentan o no los cálculos en detalle.
**/
extern void transformar_a_b10 (tNumero num, tNumero result, int *verbose);

/**
   Transforma al número num desde su base origen a la base destino. result almacena el resultado. verbose indica si se presentan o no los cálculos en detalle.
**/
extern void transformar (tNumero num, tNumero result, int *verbose);

