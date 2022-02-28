class Combo 
{
    private String nombre;
    private String descripcion;
    private int precio;
    private int cantidad;
    
    public Combo(String n, int  p, int c, String d)
    {
        nombre = n;
        precio = p;
        cantidad = c;
        descripcion = d;
    }
    
    public void vender()
    {
      cantidad--;  
    }  
    
    public String getNombre()
    {
        return nombre;
    }
    
    public int getPrecio()
    {
        return precio;
    }    
    
    public int getCantidad()
    {
        return cantidad;
    }   
    
    public String getDescripcion()
    {
        return descripcion;
    }
}