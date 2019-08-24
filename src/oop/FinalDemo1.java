package oop;

public class FinalDemo1 {
    public static void main(String[] args) {
        Other o = new Other();
        new FinalDemo1().addOne(o);
        System.out.println(o.i);
    }

    public void addOne(final Other o) {
        Other o2 = new Other();
        o.i++;
    }
}

class Other {
    public int i;
}

