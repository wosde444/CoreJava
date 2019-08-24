package com.test.thread;

class Clerk {
    private int product = 0;

    public synchronized void addProduct() {
        //如果产品>=20，暂停生产
        if (product >= 20) {
            try {
                wait();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        //如果产品小于二十，继续生产
        else {
            product++;
            System.out.println("生产者生产了第" + product + "个产品！");
            notifyAll();
        }
    }

    public synchronized void getProduct() {
        //如果产品小于等于0，暂停取货
        if (product <= 0) {
            try {
                wait();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        //如果产品大于0，开始取货
        else {
            System.out.println("消费者取了第" + product + "个产品！");
            product--;
            notifyAll();
        }
    }
}

class Productor implements Runnable {  //生产者
    Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        System.out.println("生产者开始生产产品");
        while (true) {
            try {
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
            }
            clerk.addProduct();
        }
    }
}

class Consumer implements Runnable {  //消费者
    Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        System.out.println("消费者开始取走产品");
        while (true) {
            try {
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
            }
            clerk.getProduct();
        }
    }
}


public class ShopDemo {
    public static void main(String[]args){
        Clerk clerk = new Clerk();
        Productor p = new Productor(clerk);
        Consumer c = new Consumer(clerk);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
