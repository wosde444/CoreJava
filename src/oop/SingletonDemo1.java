package oop;

//饿汉式
class Single{
    private static Single single = new Single();
    private Single(){
    }

    public static Single getSingle(){
        return single;
    }
}

public class SingletonDemo1{
    public static void main(String[]args){
        Single s1 = Single.getSingle();
        Single s2 = Single.getSingle();
        System.out.println(s1==s2);
    }

}
