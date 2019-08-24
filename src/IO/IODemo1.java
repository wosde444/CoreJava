package IO;

import java.io.*;
import java.util.Scanner;

public class IODemo1 {
    public static void main(String[] args) {

        //方法1
        /*Scanner sc = new Scanner(System.in);
        String str = null;
        System.out.print("please enter:");
        while ((str = sc.nextLine()) !=null) {
            if (str.equalsIgnoreCase("e")||str.equalsIgnoreCase("exit")){
                System.out.println("safe exit!");
                break;
            }
            System.out.println(str.toUpperCase());
            System.out.print("please enter:");
        }*/

        //方法二
        System.out.print("please enter:");
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String str;
        try {
            while ((str = bi.readLine())!=null){
                if(str.equalsIgnoreCase("e")||str.equalsIgnoreCase("exit")){
                    System.out.println("safe exit!");
                    break;
                }
                System.out.println(str.toUpperCase());
                System.out.print("please enter:");
            }
        }catch (IOException e1){
            e1.printStackTrace();
        }finally {
            try {
                bi.close();
            }catch (IOException e2){
                e2.printStackTrace();
            }
        }
    }
}
