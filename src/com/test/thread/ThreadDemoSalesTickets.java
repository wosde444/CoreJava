package com.test.thread;

class SalesTickets implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售出车票，车票号为：" + ticket--);
                } else {
                    break;
                }
            }
        }
    }
}

public class ThreadDemoSalesTickets {
    public static void main(String[] args) {
        SalesTickets tic = new SalesTickets();
        Thread t1 = new Thread(tic);
        Thread t2 = new Thread(tic);
        Thread t3 = new Thread(tic);
        t1.setName("窗口a");
        t2.setName("窗口b");
        t3.setName("窗口c");
        t1.start();
        t2.start();
        t3.start();
    }
}
