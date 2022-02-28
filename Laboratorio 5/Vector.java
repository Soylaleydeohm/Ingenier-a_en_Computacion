public class Vector
{
    //---------------------------------------------------------------------------------------------
    //---- Atributo de instancia
    //---------------------------------------------------------------------------------------------

    private float[] vec;

    //---------------------------------------------------------------------------------------------
    //---- Constructor
    //---------------------------------------------------------------------------------------------
    
    public Vector(int max)
    {
        vec = new float[max];
    }

    //---------------------------------------------------------------------------------------------
    //---- Comandos
    //---------------------------------------------------------------------------------------------
    
    /**
     * Asume que la posicion es valida
     */
    public void establecerElem(int pos, float elem)
    {
        vec[pos] = elem;
    }

    /**
     * @todo: copy(v:Vector)
     */

    //---------------------------------------------------------------------------------------------
    //---- Consultas
    //---------------------------------------------------------------------------------------------
  
    public boolean existePos(int pos) 
    {
        return (pos >= 0 && pos < vec.length);
    }
    
    public boolean existeElem(float r)
    {
        int i = 0;
        boolean existe = false;
        while ((i < vec.length) && (!existe)) {
            if (vec[i] == r) {
                existe = true;
            } else {
                i++;
            }
        }
        return existe;
    }
    
    /**
     * Asume que la posicion es valida
     */
    public float obtenerElem(int pos)
    {
        return vec[pos];
    }

    public int cantElems()
    {
        return vec.length;
    }

    /**
     * Asume que las longitudes son consistentes
     */
    public float prodEscalar(Vector v) 
    {
        float pe = 0;
        for (int i = 0; i < vec.length; i++) {
            pe += v.obtenerElem(i) * vec[i];     	
        }
        return pe;
    }
  
    /**
     * Asume que las longitudes son consistentes
     */
    public Vector suma(Vector v)
    { 
        Vector aux = new Vector(vec.length);
        float r;
        for (int i = 0; i < vec.length; i++) {
            r = vec[i] + v.obtenerElem(i); 
            aux.establecerElem(i,r);
        }
        return aux;
    }

    public Vector escalarXVector(float esc) 
    {
        Vector aux = new Vector(vec.length);
        for (int i = 0; i < vec.length; i++) {
            aux.establecerElem(i,vec[i]*esc); 
        }
        return aux;
    }

    /**
     * @todo: 
     *  + equals(v:Vector): boolean
     *  + clone():Vector
     */
}
