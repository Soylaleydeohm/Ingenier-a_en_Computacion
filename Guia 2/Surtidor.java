public class Surtidor 
{
    //Atributos de clase 
    private static final int maximaCarga = 20000;
    
    //Atributos de instancia
    private int cantGasoil;
    private int cantSuper;
    private int cantPremium;
    
    //Constructor 
    //Los constructores no son static y tampoco retornan nada.
    public Surtidor(){
    cantGasoil = maximaCarga;
    cantSuper = maximaCarga;
    cantPremium = maximaCarga;
    }
    
    //Comandos 
    
    public void llenarDepositoGasoil(){
    cantGasoil = maximaCarga;
    }
    public void llenarDepositoSuper(){
    cantSuper = maximaCarga;
    }    
    public void llenarDepositoPremium(){
    cantPremium = maximaCarga;
    }
    
    public void extraerGasoil (int litG){
    if (cantGasoil > litG)
        cantGasoil -= litG;
    else cantGasoil = 0;
    }
    public void extraerSuper (int litS){
    if (cantSuper > litS)
        cantSuper -= litS;
    else cantSuper = 0;
    }
    public void extraerPremium (int litP){
    if (cantPremium > litP)
        cantPremium -= litP;
    else cantPremium = 0;
    }
    
    //Consultas
    
    public int obtenerLitrosGasoil(){
    return cantGasoil;
    }
    public int obtenerLitrosSuper(){
    return cantSuper;
    }
    public int obtenerLitrosPremium(){
    return cantPremium;
    }
}