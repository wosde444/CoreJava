package com.test.CommonClass;

public class StringReverseDemo {
    public static void main(String[] args) {
        String str = "aab  cde fg aaa  !@sss223 12 ,.!!ee@!@#@aa3!@ 322dsfsadfsdafffffaaaaaaaaaaaasdfasdfsdafsdfsdfsdfsadfsdf";
        long start = 0;
        long end = 0;
        start = System.nanoTime();
        String s2 = Myreverse1(str);
        end = System.nanoTime();
        System.out.println(s2);
        System.out.println(end - start);

        start = System.nanoTime();
        String s1 = new StringBuilder(str).reverse().toString();
        end = System.nanoTime();
        System.out.println(s1);
        System.out.println(end - start);

        StringReverseDemo d = new StringReverseDemo();
        start = System.nanoTime();
        String s3 = d.reverseString(str,0,str.length()-1);
        end = System.nanoTime();
        System.out.println(s3);
        System.out.println(end - start);
        System.out.println(str.indexOf("aaa"));

    }

    public static String Myreverse1(String str) {
        char[] strChar = str.toCharArray();
        int len = strChar.length;
        int st = 0;
        char c;
        while (st < len) {
            c = strChar[st];
            strChar[st] = strChar[len - 1];
            strChar[len - 1] = c;
            st++;
            len--;
        }
        return String.copyValueOf(strChar);
    }

    //实现字符串指定“区间”的字符之间的反序。且指定的start和end都是包含在此区间的。
    public String reverseString(String str,int start,int end){
        char[] c = str.toCharArray();
        return reverseChar(c,start,end);}
    //实现了字符数组中指定区间字符间的反序。且指定的start和end都是包含在此区间的。
    public String reverseChar(char[] c ,int start ,int end){
        for(int x = start,y = end;x<y;x++,y--){
            swap(c,x ,y);}
        return new String(c);}
    //实现指定字符数组中两个元素的交换
    public void swap(char[] c,int i ,int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
