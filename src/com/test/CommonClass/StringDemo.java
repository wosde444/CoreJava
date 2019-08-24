package com.test.CommonClass;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = "atguigu";
        String s2 = "java";
        String s4 = "java";
        String s3 = new String("java");
        System.out.println(s2 == s3);//false
        System.out.println(s2 == s4);//true
        System.out.println(s2.equals(s3));//true
        String s5 = "atguigujava";
        String s6 = (s1 + s2).intern();
        System.out.println(s5 == s6);//true
        System.out.println(s5.equals(s6));//true
        String s7 = "mnjkd";
        int count = 0;
        for (int i = s7.length() - 1; i >= 0; i--) {
            if (s7.charAt(i) >= 'A' && s7.charAt(i) <= 'z') {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
