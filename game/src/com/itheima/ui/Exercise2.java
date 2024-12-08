package com.itheima.ui;

import java.util.Random;

public class Exercise2 {
    //解法2
    public static void main(String[] args) {
        int[] tempArr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r=new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index=r.nextInt(tempArr.length);
            int temp=tempArr[i];
            tempArr[i]=tempArr[index];
            tempArr[index]=temp;
        }
        //3.遍历数组
        for (int i = 0; i < tempArr.length; i++) {
            System.out.print(tempArr[i]+" ");
        }
        System.out.println();

        //4.创建一个二维数组
        int [][] data=new int[4][4];

        //5.给二维数组添加数据
       int index=0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                data[i][j]=tempArr[index];
                index++;
            }
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }
    }
}
