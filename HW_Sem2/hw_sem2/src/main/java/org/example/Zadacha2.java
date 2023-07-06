package org.example;

public class Zadacha2 {

    //Если необходимо, исправьте данный код (задание 2

    public static void main(String[] args) {
        zadacha();
    }

    public static void zadacha(){
        int[] intArray = {1,2,3,4,5,6,7,8,9,10};// Не было массива
        try {
            int d = 0;//Можно поменять делительы
            if(d != 0){
                double catchedRes1 = intArray[8] / d; // Нужно убрать деление на 0
                System.out.println("catchedRes1 = " + catchedRes1);
            }else {
                System.out.println("Деление на ноль не поддерживается!");
            }
        } catch (ArithmeticException e) {
            System.out.println("Нельзя делить на 0");
        }

    }
}
