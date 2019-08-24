package com.test.collection;

public class MyDate {
    //private成员变量month,day,year；
    // 并为每一个属性定义 getter, setter 方法；
    private int month;
    private int day;
    private int year;

    @Override
    public String toString() {
        return year+"-"+month+"-"+day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
