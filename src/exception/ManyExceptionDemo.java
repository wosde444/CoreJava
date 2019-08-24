package exception;

public class ManyExceptionDemo {
    public static void main(String[]args){
        //运行结果：
        //这是0除异常
        //java.lang.ArithmeticException: / by zero
        //这里是finally
        //	at exception.ManyExceptionDemo.main(ManyExceptionDemo.java:9)
        //这里是异常处理结束后的main

        //多个不同异常处理，只会处理捕获到的第一个异常，try剩下的部分不会再执行
        //直接转到finally
        try{
            int[] a = {1,2,3};
            int num = 6;
            System.out.println(num/0);
            for (int i=0;i<4;i++){//数组越界
                System.out.println(a[i]);
            }
            System.out.println("这里是try的结束");
        }catch (ArrayIndexOutOfBoundsException e1){
            System.out.println("这是数组越界异常");
            e1.printStackTrace();
        }catch (ArithmeticException e2){
            System.out.println("这是0除异常");
            e2.printStackTrace();
        }finally {
            System.out.println("这里是finally");
        }
        System.out.println("这里是异常处理结束后的main");
    }
}
