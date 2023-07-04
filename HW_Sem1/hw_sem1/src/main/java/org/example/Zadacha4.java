package org.example;

public class Zadacha4 {
//    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
//    и возвращающий новый массив, каждый элемент которого равен частному элементов
//    двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо
//    как-то оповестить пользователя.
//    Важно: При выполнении метода единственное исключение,
//    которое пользователь может увидеть - RuntimeException, т.е. ваше.

    public static void main(String[] args) {
//        int[] a = {1, 2,3, 4, 5};
//        int[] b = {5, 4, 3, 2, 1};
        // OK
//        int[] a = {1, 2,3, 4, 5};
//        int[] b = {5, 4, 0, 2, 1};
        //DELEMIE NA 0
        int[] a = {1, 2,3, 4, 5};
        int[] b = null;


        int[] res = divMassivov(a, b);



        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ",res[i]);
        }

    }
    public static int[] divMassivov(int[] arr1, int[] arr2){
        if (arr1 != null && arr2 != null){
            if(arr1.length != arr2.length){
//            System.out.println("Массивы разных размеров!");
//            return null;
                throw new RuntimeException("Размеры массивов не равны!");
            }else {
                int[] res = new int[arr2.length];
                for (int i = 0; i <res.length ; i++) {
                    if(arr2[i] != 0){
                        res[i] = arr1[i]/arr2[i];
                    }else {
                        throw new RuntimeException("Массив на который производится деление, содержит ноль!");
                    }

                }
                return res;
            }
        }else {
            throw new RuntimeException("Один из массивов - null");
        }
    }

}
