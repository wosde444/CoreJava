package test;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ListRandomManagement {
    int arr[] = {};
    final int MAXEDGE = 65536;

    private void init() throws IOException {
        System.out.print("请输入数组的初始长度：");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        arr = new int[length];
        Random rd = new Random();
        int i, j;
        for (i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(2 * arr.length);//此处设置元素值范围为[0,2*arr.length),可更改
            while (true) {
                for (j = 0; j < i; j++) {
                    if (arr[i] == arr[j]) {
                        arr[i] = rd.nextInt(2 * arr.length);//此处设置元素值范围为[0,2*arr.length),可更改
                        j = 0;
                        break;
                    }
                }
                if (j == i) break;
            }
        }
    }

    private void add() {
        int[] tempArr = new int[arr.length + 1];
        Random rd = new Random();

        int i;
        for (i = 0; i < tempArr.length; i++) {
            tempArr[i] = MAXEDGE;
        }

        while (true) {
            for (i = 0; i < arr.length; i++) {
                tempArr[tempArr.length - 1] = rd.nextInt(2 * arr.length);
                if (arr[i] == tempArr[tempArr.length - 1]) {
                    tempArr[tempArr.length - 1] = rd.nextInt(2 * arr.length);//此处设置元素值范围为[0,2*arr.length),可更改
                    i = 0;
                    break;
                }
            }
            if (i == arr.length) break;
        }


        for (i = 0; i < arr.length; i++) {
            while (true) {
                int x = rd.nextInt(tempArr.length);//此处设置元素值范围为[0,2*arr.length),可更改
                if (tempArr[x] == MAXEDGE) {
                    tempArr[x] = arr[i];
                    break;
                }
                if (i == arr.length) break;
            }

        }
        arr = tempArr;
    }

    private void del(int index) {
        int[] tempArr = new int[arr.length - 1];
        Random rd = new Random();
        int i;
        for (i = 0; i < tempArr.length; i++) {
            tempArr[i] = MAXEDGE;
        }

        for (i = 0; i < arr.length; i++) {
            if(i == index){
                continue;
            }
            while (true) {
                int x = rd.nextInt(tempArr.length);//此处设置元素值范围为[0,2*arr.length),可更改
                if (tempArr[x] == MAXEDGE) {
                        tempArr[x] = arr[i];
                        break;
                    }
                }
                if (i == arr.length) break;
            }
        arr = tempArr;
    }

    private void show() {
        System.out.print("[ ");
        for (int e : arr) {
            System.out.print(e + "  ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) throws IOException {
        ListRandomManagement l = new ListRandomManagement();
        l.init();
        l.show();
        l.add();
        l.show();
        System.out.print("请输入要删除的元素下标：");
        int n = new Scanner(System.in).nextInt();
        l.del(n);
        l.show();
    }
}
