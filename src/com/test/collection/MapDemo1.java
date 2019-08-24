package com.test.collection;

import java.util.*;

public class MapDemo1 {
    //请把学生名与考试分数录入到Map中，并按分数显示前三名成绩学员的名字。
    public static void main(String[]args){
        Map stuGrade = new TreeMap();
        Scanner sc = new Scanner(System.in);
        for (int i = 0;i<5;i++){
            stuGrade.put(sc.nextInt(),sc.next());
        }
        Iterator entries = stuGrade.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            Integer key = (Integer)entry.getKey();
            String value = (String)entry.getValue();
            System.out.println("Key = " + key + ", Value = " + value);

        }
    }
}
