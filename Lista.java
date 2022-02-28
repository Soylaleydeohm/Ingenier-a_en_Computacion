import java.io.*;
public class Lista
{
    //Atributo de clase
    private int cant = 7840;
    
    //Atributos de instancia
    private ObjetoCeleste [] objeto;    
    
    //Constructor
    public Lista()
    {
        objeto = new ObjetoCeleste[cant];        
        agregarElementos();
    }
    
    //Comandos
    public void agregarElementos()
    {
        try
        {
            BufferedReader in = new BufferedReader (new FileReader("todos.txt"));
            String s;
            String name;
            String cons;
            String desc;
            String aDesc;
            String type;
            String type2;
            String x;
            String y;
            String z;
            String distZ;
            String distNED;            
            String nM;
            int i = 0;
            while(((s = in.readLine()) != null)&&(i < cant))
            {
                String datos[] = new String [13];
                datos = s.split(";");
                name = datos[0]+datos[1];
                cons = datos[6];
                desc = datos[7];
                aDesc = datos[8];
                type = datos[2];
                type2 = datos[3];
                x = datos[4];
                y = datos[5];
                z = datos[9];
                distZ = datos[10];
                distNED = datos[11];    
                nM = datos[12];
                if (!nM.equals("0"))
                    objeto[i] = new ObjetoMessier(name, cons, desc, aDesc, type, x, y, z, distZ, distNED, nM);
                    else
                    objeto[i] = new ObjetoCeleste(name, cons, desc, aDesc, type, x, y, z, distZ, distNED);
                i++;
            }

        }
        catch(IOException err)
        {
            System.out.println("Error al leer el archivo");
        }
    }
    
    //Consultas
    public int obtenerCantidad()
    {
        return cant;
    }
    
    public ObjetoCeleste obtenerElemento(int pos)
    {
        return objeto[pos];
    }
    
    public ObjetoCeleste obtenerElemento(String name)
    {
        ObjetoCeleste o = null;
        boolean encontre = false;
        int i = 0;
        while (i < cant && !encontre)
        {
            encontre = ((objeto[i].obtenerNombre()).equals(name));
            i++;
        }
        if (encontre)
            o = objeto[i-1];
        return o;
    }    
}
