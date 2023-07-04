package org.example;

public class Zadacha3 {
    //Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    // и возвращающий новый массив, каждый элемент которого равен разности элементов
    // двух входящих массивов в той же ячейке. Если длины массивов не равны,
    // необходимо как-то оповестить пользователя.

    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5};
//        int[] b = {5, 4, 3, 2, 1};
//        int[] res = raznicaMassivov(a, b);

        int[] a = {1, 2, 4, 5};
        int[] b = {5, 4, 3, 2, 1};
        int[] res = raznicaMassivov(a, b);



        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ",res[i]);
        }
    }

    public static int[] raznicaMassivov(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
//            System.out.println("Массивы разных размеров!");
//            return null;
            throw new RuntimeException("Размеры массивов не равны!");
        }else {
            int[] res = new int[arr2.length];
            for (int i = 0; i <res.length ; i++) {
                res[i] = arr1[i] - arr2[i];
            }
            return res;
        }
    }
}
