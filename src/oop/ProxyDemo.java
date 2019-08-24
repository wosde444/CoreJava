package oop;

interface Man {
    void action();
}

class ProxyMan implements Man{
    Man man;
    public void action(){
        System.out.println("代理开始");
        man.action();
        System.out.println("代理结束");
    }
    public ProxyMan(){
        man = new RealMan();
    }
}
class RealMan implements Man{
    public void action(){
        System.out.println("======");
        System.out.println("======");
        System.out.println("被代理的类");
        System.out.println("======");
        System.out.println("======");
    }
}

public class ProxyDemo {
    public static void main(String[]args){
        Man man = new ProxyMan();
        man.action();
    }
}
