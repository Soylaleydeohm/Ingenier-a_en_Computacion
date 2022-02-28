
public class Tester
{
    public static void main (String [] args)
    {
        Uno u1, u2, u3, u4;
        Dos d1, d2, d3;
        Tres t1, t2, t3;
        
        t3 = new Tres();
        u1 = new Uno();
        u2 = new Dos();
        u3 = new Tres();
        u4 = t3;
        //d1 = new Uno();
        d2 = new Dos();
        d3 = new Tres();
       // t1 = (Tres) u2;
        t2 = (Tres) d3;
        
        
        System.out.println(u1.f());
        System.out.println(u2.f());
        System.out.println(u3.f());
        System.out.println(u4.f());
        //System.out.println(d1.f());
        System.out.println(d2.f());
        System.out.println(d3.f());
        //System.out.println(t1.f());
        System.out.println(t2.f());
        System.out.println(t3.f());        
        //System.out.println(u1.f(11));
        //System.out.println(u2.f(11));
        //System.out.println(u3.f(11));
        //System.out.println(u4.f(11));
        //System.out.println(d1.f(11));
        System.out.println(d2.f(11));
        System.out.println(d3.f(11));
        
        System.out.println(u1.g());
        System.out.println(u2.g());
        System.out.println(u3.g());
        System.out.println(u4.g());
       // System.out.println(d1.g());
        System.out.println(d2.g());
        System.out.println(d3.g());
       // System.out.println(t1.g());
        System.out.println(t2.g());
        System.out.println(t3.g());
        System.out.println(u1.h());
        System.out.println(u2.h());
        System.out.println(u3.h());
        System.out.println(u4.h());
        //System.out.println(d1.h());
        System.out.println(d2.h());
        System.out.println(d3.h());        
                    
        //System.out.println(u1.l());
        //System.out.println(u2.l());
        //System.out.println(u3.l());
        //System.out.println(u4.l());
        //System.out.println(d1.l());
        //System.out.println(d2.l());
        //System.out.println(d3.l());          
      //  System.out.println(t1.f(11));
        System.out.println(t2.f(11));
        System.out.println(t3.f(11));
       // System.out.println(t1.h());
        System.out.println(t2.h());
        System.out.println(t3.h());
       // System.out.println(t1.l());
        System.out.println(t2.l());
        System.out.println(t3.l());
      
        

    }
}
