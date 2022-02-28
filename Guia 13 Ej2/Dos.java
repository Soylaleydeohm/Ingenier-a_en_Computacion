
public class Dos extends Uno
{
    int f (int x) {return x;}
    int g () {return f()+10;}
    int h () {return super.h()+100;}
}
