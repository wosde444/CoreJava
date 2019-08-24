package com.test.thread;

//.定义一个Account类
//1）该Account类封装了账户编号（String）和余额（double）两个属性
//2）设置相应属性的getter和setter方法
//3）提供无参和有两个参数的构造器
//4）系统根据账号判断与用户是否匹配，需提供hashCode()和equals()方法的重写
class Account {
    private String accountID;
    private double balance;
    public Account() {
        this.accountID = null;
        this.balance = 0;
    }

    public Account(String accountID, double balance) {
        this.accountID = accountID;
        this.balance = balance;
    }

    public String getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String toString() {
        return "Account [accountID=" + accountID + ", balance=" + balance + "]";
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((accountID == null) ? 0 : accountID.hashCode());
        long temp;
        temp = Double.doubleToLongBits(balance);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (accountID == null) {
            if (other.accountID != null) return false;
        } else if (!accountID.equals(other.accountID))
            return false;
        if (Double.doubleToLongBits(balance) != Double
                .doubleToLongBits(other.balance))
            return false;
        return true;
    }
}

//提供一个取钱的线程类
//1）提供了Account类的account属性和double类的取款额的属性
//2）提供带线程名的构造方法
//3）run()方法中提供取钱的操作

class WithDrawThread extends Thread {
    private Account account;
    private double withDraw;

    public WithDrawThread(String name, Account account, double withDraw) {
        super(name);
        this.account = account;
        this.withDraw = withDraw;
    }

    @Override
    public void run() {
        synchronized (account) {
            if (account.getBalance() > withDraw) {
                System.out.println(Thread.currentThread().getName()+"取款成功！取款额为：" + withDraw);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setBalance(account.getBalance() - withDraw);
            } else {
                System.out.println(Thread.currentThread().getName()+"取款失败！余额不足！");
                System.out.println("现在账户的余额为：" + account.getBalance());
            }
        }
    }
}

public class BankTestDemo {
    public static void main(String[]args){
        Account account = new Account("1234567",10000);
        Thread t1 = new WithDrawThread("小明",account,8000);
        Thread t2 = new WithDrawThread("小明's wife",account,2800);
        t1.start();
        t2.start();

    }
}
