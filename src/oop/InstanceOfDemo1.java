package oop;

class Person{
    String name;

    public String getName() {
        return name;
    }
}

class student extends Person{
    int age;

    public int getAge() {
        return age;
    }
}

public class InstanceOfDemo1 {
    public static void main(String[]args){
        student stu = new student();
        System.out.println(stu instanceof Object);
    }
}
