
public class Tester
{
    public static void main (String [] args)
    {
        Uno u1, u2, u3, u4;
        Dos d1, d2;
        Tres t;
        
        t = new Tres();
        u1 = new Uno();
        u2 = new Dos();
        u3 = new Tres();
        u4 = t;
        d1 = new Dos();
        d2 = new Tres();
        
        
        System.out.println(u1.f());
        System.out.println(u2.f());
        System.out.println(u3.f());
        System.out.println(u4.f());
        System.out.println(u1.g());
        System.out.println(u2.g());
        System.out.println(u3.g());
        System.out.println(u4.g());
        System.out.println(u1.h());
        System.out.println(u2.h());
        System.out.println(u3.h());
        System.out.println(u4.h());
      
        System.out.println(d1.f());
        System.out.println(d2.f());
        System.out.println(d1.f(-1));
        System.out.println(d2.f(-1));
        System.out.println(d1.g());
        System.out.println(d2.g());
        System.out.println(d1.h());
        System.out.println(d2.h());
        
        System.out.println(t.f());
        System.out.println(t.g());
        System.out.println(t.h());
        System.out.println(t.f(-1));
        System.out.println(t.l());
    }
}
