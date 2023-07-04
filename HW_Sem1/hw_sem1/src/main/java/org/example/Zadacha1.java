package org.example;

public class Zadacha1 {
    public static void main(String[] args) {
//        Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
        //int res1 = method1("124O");
        //Exception in thread "main" java.lang.NumberFormatException: For input string: "124O"

        //int res2 = method2(1,3);
        //Exception in thread "main" java.lang.ArithmeticException: / by zero

        int[] res3 = method3(9);
        //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9

    }
    public static int method1(String str){
        return Integer.parseInt(str);
    }
    public static int method2(int a, int b){
        int c = b-b;
        return a/c;
    }
    public static int[] method3(int a){
        int[] arr = new int[a];
        for (int i = 0; i < a + 1; i++) {
            arr[i] = i;
        }
        return arr;
    }



}
