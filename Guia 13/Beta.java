
public class Beta extends Alfa
{
    protected int m;
    protected String ss;
    
    public Beta(){
        m= 11;
        ss= new String ("Beta");
    }
    
    public String p(int x){
        return ss+" p m: "+m+" x: "+x;
    }
    
    public String q(String x){
        return ss+" q m: "+m+" x: "+x;
    }
}
