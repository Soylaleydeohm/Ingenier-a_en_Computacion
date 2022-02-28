public class ProcesadorNumero
{
    /* 
     * Retorna true si y solo si d es un dígito del número n 
     */
    public static boolean estaDigito ( int n, int d )
    {
        boolean esta = false;
        while ((n > 0) && !esta) {
            if (d == n % 10) {//Está mirando si coincide el último dígito
                esta = true;//Si coincide el último dígito pasa a ser "true", sino, divide por 10 al número y se fija qué pasa en la siguiente cifra
            }
            n = n / 10; // También se podría codificar:  n /= 10;        
        }
        return esta;
    }
    
    /* 
     * Retorna la suma de los dígitos del número n 
     */
    public static int sumaDigitos ( int n )
    {
        int suma = 0;
        while (n > 0) {
            suma = suma + n % 10; // Equivalente a suma += n % 10;
            n = n / 10;
        }
        return suma;
    }
    
    /* 
     * Retorna la suma de los dígitos pares del número n 
     */
    public static int sumaP ( int n )
    {
        int suma = 0;
        if (n < 10){
           if (n % 2 == 0) {
               suma = n;
           }
        }
        else {
           suma = sumaP(n / 10);
           if (n % 2 == 0) {
              suma = suma + n % 10;
           }
        }
        return suma;
    }
    
    /**
     * EJERCICIOS:
     * 
     * Implementar 
     *  + un método iterativo contarDigitos(n:entero)
     *  + un método iterativo esSumaMayor(n,m:entero) que retorna true si la suma de los dígitos de n es mayor a m 
     *  + un método recursivo contarDigitosPares(n:entero) 
     * 
     */
    
    /* 
     * Retorna la cantidad de dígitos del número n 
     */    
    public static int contarDigitos (int n)
    {
        int dig=0;
        while(n>0){
            dig++;
            n/=10;
        }
        return dig;
    }
    
     /* 
     * Retorna true si y solo si la suma de los dígitos de n es mayor a m
     */
    public static boolean esSumaMayor ( int n, int m )
    {
        boolean es = false;
        int suma = 0;
        while ((n > 0) && !es) {
            if (m < suma) {//Está mirando si la suma es mayor que m
                es = true;//Si es así, "es" pasa a ser "true", sino, divide por 10 al número y se fija qué pasa al sumar el siguiente dígito
            }else{
            suma = suma + n % 10;
            n = n / 10; // También se podría codificar:  n /= 10;
        }
        }
        return es;    
        }
     
     /* 
     * Retorna la cantidad de dígitos pares del número n 
     */    
    public static int contarDigitosPares ( int n )
    {
        int contar = 0;
        if (n < 10){
           if (n % 2 == 0) {
               contar++;
           }
        }
        else {
           contar = contarDigitosPares(n / 10);
           if (n % 2 == 0) {
              contar++;
           }
        }
        return contar;
    }
    
    public static void main (String[] args)
    { 
        //-------------------------------------------------------------------------
        //-- Testeo del método estaDigito
        //-------------------------------------------------------------------------
        
        // Prueba #1 
        int numero = 113154;
        int dig = 8;
        int m = 5;
        int numero2 = 27845;
        int contarP;
        boolean esta = estaDigito(numero, dig);
        boolean esSuma;
        if (esta) {
            System.out.println("El dígito " + dig + " ESTÁ en " + numero);
        } else {
            System.out.println("El dígito " + dig + " NO ESTÁ en " + numero);
        }
        
        // Prueba #2 
        dig = 3;
        esta = estaDigito(numero, dig);
        if (esta) {
            System.out.println("El dígito " + dig + " ESTÁ en " + numero);
        } else {
            System.out.println("El dígito " + dig + " NO ESTÁ en " + numero);
        }
        
        //-------------------------------------------------------------------------
        //-- Testeo del método sumaDigitos
        //-------------------------------------------------------------------------
        
        int suma= sumaDigitos(numero);
        System.out.println("La suma del número " + numero + " es " + suma);
        
        //-------------------------------------------------------------------------
        //-- Testeo del método sumaP
        //-------------------------------------------------------------------------
        
        System.out.println("La suma de los dígitos pares es " + sumaP(numero));
        
        //-------------------------------------------------------------------------
        //-- Testeo del método contarDigitos
        //-------------------------------------------------------------------------
        
        int digitos= contarDigitos(numero);
        System.out.println("La cantidad de dígitos del número " + numero + " es " + digitos);
        
        //-------------------------------------------------------------------------
        //-- Testeo del método esSumaMayor
        //-------------------------------------------------------------------------
        
        esSuma= esSumaMayor(numero, m);
        if (esSuma) {
            System.out.println("La suma de los dígitos de " + numero + " ES MAYOR que " + m);
        } else {
            System.out.println("La suma de los dígitos de " + numero + " ES MENOR que " + m);
        }
        
        // Prueba #2 
        m = 78;
        esSuma= esSumaMayor(numero, m);
        if (esSuma) {
            System.out.println("La suma de los dígitos de " + numero + " ES MAYOR que " + m);
        } else {
            System.out.println("La suma de los dígitos de " + numero + " ES MENOR que " + m);
        }
        //-------------------------------------------------------------------------
        //-- Testeo del método contarDigitos
        //-------------------------------------------------------------------------
        
        contarP= contarDigitosPares(numero);
        System.out.println("La cantidad de dígitos del número " + numero + " es " + contarP);
        
        // Prueba #2 
        contarP= contarDigitosPares(numero2);
        System.out.println("La cantidad de dígitos del número " + numero2 + " es " + contarP);
       }
    }

