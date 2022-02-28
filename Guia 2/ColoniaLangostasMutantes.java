import java.util.Random;
public class ColoniaLangostasMutantes{
    //Atributos de instancia
    private static int machos;
    private static int hembras;
    
    //Constructor
    public ColoniaLangostasMutantes(){
        machos = 1;
        hembras = 1;
    }
    
    //Comandos
    public void reproduccionEnLaColonia(){
        int i, h;
        h = hembras;
        for (i = 0; i < h; i++)
            reproduccion();        
    }
    
    public void reproduccion(){
        char cria = tenerCria();
        if(cria == 'h')
            hembras += 1;
        else {
            machos += 1;
            reproduccion();
        }
    }
    
    //Consultas
    public char tenerCria(){
        Random gen = new Random();
        int rand = gen.nextInt(2);
        char c;        
        if(rand == 0)
            c = 'h';
        else
            c = 'm';
       return c;
    }
    
    public int ejemplaresColonia(){
        return machos + hembras;
    }
    
    public String toString(){
        return "La colonia posee "+machos+" machos y "+hembras+" hembras"; 
    }
}
