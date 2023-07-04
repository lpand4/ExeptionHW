package org.example;

public class Zadacha2 {
    public static void main(String[] args) {
        sum2d(null);
    }
    public static int sum2d(String[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {  //NullPointerException
            for (int j = 0; j < 5; j++) {      //.ArrayIndexOutOfBoundsException
                int val = Integer.parseInt(arr[i][j]);  // NumberFormatException
                sum += val;

            }
        }
        return sum;
    }
}
