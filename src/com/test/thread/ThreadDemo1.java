package com.test.thread;

class MyThread1 extends Thread{
    @Override
    public void run() {
        for(int i = 1;i<=100;i=i+2){
            System.out.println("线程1："+i);
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for(int i = 2;i<=100;i=i+2){
            System.out.println("线程2："+i);
        }
    }
}

public class ThreadDemo1 {
    public static void main(String[]args){
        MyThread1 mt1 = new MyThread1();
        MyThread2 mt2 = new MyThread2();
        mt2.setPriority(10);
        mt1.start();
        mt2.start();
    }
}
