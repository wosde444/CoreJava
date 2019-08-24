package com.test.thread;

public class TestDeadLock {
    static StringBuffer s1 = new StringBuffer();
    static StringBuffer s2 = new StringBuffer();

    public static void main(String[] args) {
        new Thread() {
            public void run() {
                synchronized (s1) {
                    s2.append("A");
                    synchronized (s2) {
                        s2.append("B");
                        System.out.print(s1);
                        System.out.print(s2);
                    }
                }
            }
        }.start();
        new Thread() {
            public void run() {
                synchronized (s2) {
                    s2.append("C");
                    synchronized (s1) {
                        s1.append("D");
                        System.out.print(s2);
                        System.out.print(s1);
                    }
                }
            }
        }.start();
    }
}

