package oop;

public class InnerClassDemo {

    class Inner {
        public int a = 5;
    }

    public InnerClassDemo() {
        Inner s1 = new Inner();
        s1.a = 10;
        Inner s2 = new Inner();
        s2.a = 20;
        InnerClassDemo.Inner s3 = new InnerClassDemo.Inner();
        System.out.println(s3.a);//5
    }

    public static void main(String[] args) {
        InnerClassDemo t = new InnerClassDemo();
        Inner r = t.new Inner();
        System.out.println(r.a);//5
    }
}

