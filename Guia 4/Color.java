
public class Color
{
    //Atributos de instancia
    private int rojo;
    private int azul;
    private int verde;
    
    //Constructor
    public Color()
    {//Inicializa en blanco
        rojo = 255;
        azul = 255;
        verde = 255;
    }
    
    //Comandos
    public void variar (int val)
    {
        rojo += val;
        azul += val;
        verde += val;
        if (rojo > 255)
            rojo = 255;
        else if (rojo < 0)
            rojo = 0;
        if (azul > 255)
            azul = 255;
        else if (azul < 0)
            azul = 0;
        if (verde > 255)
            verde = 255;
        else if (verde < 0)
            verde = 0;
    }
    
    public void variarRojo (int val)
    {
        rojo += val;
        if (rojo > 255)
            rojo = 255;
        else if (rojo < 0)
            rojo = 0;
    }
    
    public void variarAzul (int val)
    {
        azul += val;
        if (azul > 255)
            azul = 255;
        else if (azul < 0)
            azul = 0;
    }
    
    public void variarVerde (int val)
    {
        verde += val;
        if (verde > 255)
            verde = 255;
        else if (verde < 0)
            verde = 0;
    }
    
    public void establecerRojo (int val)
    {
        rojo = val;
        if (rojo > 255)
            rojo = 255;
        else if (rojo < 0)
            rojo = 0;
    }
    
    public void establecerAzul (int val)
    {
        azul = val;
        if (azul > 255)
            azul = 255;
        else if (azul < 0)
            azul = 0;
    }
    
    public void establecerVerde (int val)
    {
        verde = val;
        if (verde > 255)
            verde = 255;
        else if (verde < 0)
            verde = 0;
    }
    
    public void copy (Color p)
    {
        rojo = p.obtenerRojo();
        azul = p.obtenerAzul();
        verde = p.obtenerVerde();
    }
    
    //Consultas
    
    public int obtenerRojo()
    {
        return rojo;
    }
    
    public int obtenerAzul()
    {
        return azul;
    }
    
    public int obtenerVerde()
    {
        return verde;
    }
    
    public boolean esRojo()
    {
        boolean es = false;
        if (rojo == 255 && azul == 0 && verde == 0)
            es = true;
        return es;
    }
    
    public boolean esGris()
    {
        boolean es = false;
        if (rojo == verde && azul == verde && rojo != 0 && rojo != 255)
            es = true;
        return es;
    }
    
    public boolean esNegro()
    {
        boolean es = false;
        if (rojo == 0 && azul == 0 && verde == 0)
            es = true;
        return es;
    }
    
    public Color complemento ()
    {
        Color color = new Color();
        color.establecerRojo(255 - rojo);
        color.establecerAzul(255 - azul);
        color.establecerVerde(255 - verde);
        return color;
    }
    
    public boolean equals (Color p)
    {
        return (rojo == p.obtenerRojo() && azul == p.obtenerAzul() && verde == p.obtenerVerde());
    }
    
    public Color clone()
    {
        Color color = new Color();
        color.establecerRojo(rojo);
        color.establecerAzul(azul);
        color.establecerVerde(verde);
        return color;
    }
    
    public String toString ()
    {
        return "El color está compuesto por rojo " + rojo + " azul " + azul + " y verde " + verde;
    }
}
