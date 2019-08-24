package com.test.thread;

class Communication implements Runnable {
    private int i = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (i <= 100) {
                    notify();
                    System.out.println(Thread.currentThread().getName() + "输出：" + (i++));
                } else {
                    notify();
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class CommunicationDemo1 {
    public static void main(String[] args) {
        Communication c = new Communication();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.setName("A");
        t2.setName("B");
        t1.start();
        t2.start();
    }
}
