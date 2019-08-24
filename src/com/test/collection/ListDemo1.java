package com.test.collection;

import java.util.*;
import java.util.stream.Collectors;

public class ListDemo1 {
    //请从键盘随机输入10个整数保存到List中，并按倒序、从大到小的顺序显示出来
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        //List list = new ArrayList<>(Arrays.asList(array));
        List list = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.print("normal:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print("  ");
        }
        System.out.println();
        System.out.print("reverse");
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print("  ");
        }
        System.out.println();
        Collections.sort(list);
        System.out.print("sorted:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print("  ");
        }


    }
}
