package com.test.collection;

public class Employee {
    //该类包含：private成员变量name,age,birthday，其中 birthday 为 MyDate 类的对象；
    //并为每一个属性定义 getter, setter 方法；
    //并重写 toString 方法输出 name, age, birthday
    private String name;
    private int age;
    private MyDate birthday;

    @Override
    public String toString() {
        return "name:"+name+"  age:"+age+"  birthday"+birthday;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}
