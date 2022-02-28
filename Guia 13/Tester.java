
public class Tester
{
    public static void main (String [] args)
    {
        Alfa a1 = new Alfa();
        Alfa a2 = new Beta();
        Beta a3 = new Beta();
        Alfa a4 = new Delta();
        Beta a5 = new Delta();
        Delta a6 = new Delta();
        
        System.out.println(a1.p(5));
        System.out.println(a2.p(5));
        System.out.println(a3.p(5));
        System.out.println(a4.p(5));
        System.out.println(a5.p(5));
        System.out.println(a6.p(5));
        
        System.out.println(a1.q(6));
        System.out.println(a2.q(6));
        System.out.println(a3.q(6));
        System.out.println(a4.q(6));
        System.out.println(a5.q(6));
        System.out.println(a6.q(6));
        
        System.out.println(a1.r(7));
        System.out.println(a2.r(7));
        System.out.println(a3.r(7));
        System.out.println(a4.r(7));
        System.out.println(a5.r(7));
        System.out.println(a6.r(7));
        
        //System.out.println(a1.q("q8"));
        //System.out.println(a2.q("q8"));
        System.out.println(a3.q("q8"));
        //System.out.println(a4.q("q8"));
        System.out.println(a5.q("q8"));
        System.out.println(a6.q("q8"));
        
        //System.out.println(a1.t(9));
        //System.out.println(a2.t(9));
        //System.out.println(a3.t(9));
        //System.out.println(a4.t(9));
        //System.out.println(a5.t(9));
        System.out.println(a6.t(9));
        
        System.out.println(a1.v(7));
        System.out.println(a2.v(7));
        System.out.println(a3.v(7));
        System.out.println(a4.v(7));
        System.out.println(a5.v(7));
        System.out.println(a6.v(7));


    }
}
