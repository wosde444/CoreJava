package com.test.CommonClass;

public class SplitDemo {
    public static void main(String[] args) {
        String[] fakeFileData = {
                "justin\t64/5/26\t0939002302\t5433343",
                "momor\t68/7/23\t0939100391\t5432343"};
        for (String data : fakeFileData) {
            String[] tokens = data.split("\t");
            //\t为字符串的分割符号。          
            for (String token : tokens) {
                System.out.print(token + "\t| ");
            }
            System.out.println();
        }
    }
}
