package org.example;

import java.io.FileNotFoundException;

public class Zadacha3 {
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            if(b != 0){
                System.out.println(a / b); // Добавляем проверку, чтобы не было арифметик эксепшена
            }else {
                System.out.println("Деление на 0 не предусмотрено!");
            }
            printSum(23, 234);
            int[] abc = { 1, 2 };
            if(abc.length > 3){
                abc[3] = 9;
            }else {
                System.out.println("Массив рассчитан на меньшее кол-во элементов!");
            }
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

}
