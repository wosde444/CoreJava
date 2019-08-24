package com.test.CommonClass;

public class TrimDemo {
    public static void main(String[] args) {
        String s1 = "  dfgfd   ";
        String s2byJavaTrim = s1.trim();
        System.out.println(s2byJavaTrim);
        String s3 = myTrimMethod(s1);
        System.out.println(s3);
        System.out.println(s3 == s2byJavaTrim);//false
        System.out.println(s3.equals(s2byJavaTrim));//true
    }

    public static String myTrimMethod(String str) {
        int len = str.length();
        int st = 0;
        char[] strChar = str.toCharArray();
        while (st < len && strChar[st] <= ' ') {
            st++;
        }
        while (st < len && strChar[len - 1] <= ' ') {
            len--;
        }
        return ((st > 0) || (len < str.length())) ? str.substring(st, len) : str;
    }
}
