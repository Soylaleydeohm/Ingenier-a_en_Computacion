public class Empleado {
    //Atributos de instancia
    private int legajo;
    private int cantHoras;
    private float valorHora;
    
    //Constructores
    public Empleado (int leg) {
    legajo = leg;
    }
    public Empleado (int leg, int canth, float valorh){
    legajo = leg;
    cantHoras = canth;
    valorHora = valorh;
    }
    
    //Comandos
    public void establecerValorHora (float s){
    valorHora = s;
    }
    public void establecerCantHoras (int ch){
    cantHoras = ch;
    }
    
    //Consultas
    public int obtenerLegajo(){
    return legajo;
    }    
    public float obtenerSueldo(){
    float sueldo;
    sueldo = cantHoras * valorHora;
    return sueldo;
    }
    public int obtenerCantHoras(){
    return cantHoras;
    }    
    public float obtenerValorHoras(){
    return valorHora;
    }
    }
