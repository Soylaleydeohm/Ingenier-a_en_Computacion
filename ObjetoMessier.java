
public class ObjetoMessier extends ObjetoCeleste
{
    //Atributos de instancia
    protected String nombreM;
    
    //Constructor
    public ObjetoMessier(String name, String cons, String desc, String aDesc, String type, String x, String y, String z, String distZ, String distNED, String nM)
    {
        super(name, cons, desc, aDesc, type, x, y, z, distZ, distNED);
        nombreM = nM;
    }
    //Consultas
    public String obtenerNombreMessier()
    {
        return nombreM;
    }
}
