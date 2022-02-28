
public class Delta extends Beta
{
    protected int l;
    protected char ch;
    
    public Delta(){
        l= 12;
        ch = 'D';
    }
    
    public String q(int x){
        return ch+" q l: "+l+" x: "+x;
    }
    
    public String t(int x){
        return ch+" t l: "+l+" x: "+x;
    }
    
    public String v(char x){
        String sss= ch+" v l: "+l+" x: "+x;
        return sss;
    }
}
