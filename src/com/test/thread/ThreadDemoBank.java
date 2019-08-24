package com.test.thread;

class BankAccount implements Runnable {
    private int money = 0;
    //明确哪些代码是多线程运行代码，须写入run()方法
    //明确什么是共享数据。
    //明确多线程运行代码中哪些语句是操作共享数据的。
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            synchronized (this) {
                money += 1000;
                System.out.println(Thread.currentThread().getName() + "存入1000元，现有存款：" + money);
            }
        }
    }
}

//银行有一个账户。
//有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
public class ThreadDemoBank {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        Thread t1 = new Thread(ba);
        Thread t2 = new Thread(ba);
        t1.setName("A");
        t2.setName("B");
        t1.start();
        t2.start();
    }
}
