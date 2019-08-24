package oop;

import java.util.Scanner;
import java.util.Vector;

public class IntegerDemo1 {
    //利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩等级。
    //提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。而向量类java.util.Vector可以根据需要动态伸缩。
    //创建Vector对象：Vector v=new Vector();
    //给向量添加元素：v.addElement(obj);   //obj必须是对象
    //取出向量中的元素：Object  obj=v.elementAt(0);
    //注意第一个元素的下标是0，返回值是Object类型的。
    //计算向量的长度：v.size();
    //若与最高分相差10分内：A等；20分内：B等；30分内：C等；其它：D等

    public static void main(String[] args) {
        Vector<Integer> v = new Vector();
        Scanner sc = new Scanner(System.in);
        int num;
        int max = 0;
        while (true) {
            num = sc.nextInt();
            if (num >= 0) {
                v.addElement(num);
                if (num > max) {
                    max = num;
                }
            } else {
                break;
            }
        }
        for (int i = 0; i < v.size(); i++) {
            int cha = max - v.elementAt(i);
            String scoreClass;
            //若与最高分相差10分内：A等；20分内：B等；30分内：C等；其它：D等
            if (cha <= 10) {
                scoreClass = "A";
            } else if (cha <= 20) {
                scoreClass = "B";
            } else if (cha <= 30) {
                scoreClass = "C";
            } else {
                scoreClass = "D";
            }
            System.out.println("分数：" + v.elementAt(i) + "   等级：" + scoreClass);
        }
    }
}
