package exception;

public class TryCatchFinallyDemo {
    public static void main(String[]args){
        try{
            int i = 6;
            int zero = 0;
            //int divide = zero/zero;
            System.out.println(0/zero);
        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            System.out.println("end");
        }
        System.out.println("end main");//会执行到这里，也会抛出异常
        //end
        //java.lang.ArithmeticException: / by zero
        //end main
        //	at exception.TryCatchFinallyDemo.main(TryCatchFinallyDemo.java:9)

        //无异常处理例子
        int i = 6;
        int zero = 0;
        System.out.println(i/zero);
        System.out.println("end main");//不会执行到这里，抛出异常信息如下

        //Exception in thread "main" java.lang.ArithmeticException: / by zero
        //	at exception.TryCatchFinallyDemo.main(TryCatchFinallyDemo.java:19)
    }
}
