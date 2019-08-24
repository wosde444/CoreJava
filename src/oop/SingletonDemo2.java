package oop;

//懒汉式，暂时线程不安全
class Singleton2 {
    private static Singleton2 s2 = null;

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        if (s2 == null) {
            s2 = new Singleton2();
        }
        return s2;
    }
}

public class SingletonDemo2 {
    public static void main(String[] args) {
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s1 == s2);
    }
}
