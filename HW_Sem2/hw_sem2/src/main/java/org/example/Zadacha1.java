package org.example;

import java.util.Scanner;

public class Zadacha1 {
//    Реализуйте метод, который запрашивает у пользователя
//    ввод дробного числа (типа float), и возвращает введенное значение.
//    Ввод текста вместо числа не должно приводить к падению приложения,
//    вместо этого, необходимо повторно запросить у пользователя ввод данных.
    public static void main(String[] args) {
        printFloat();
    }
    public static void printFloat(){
        Scanner sc = new Scanner(System.in);
        float res = 0;
        boolean flag = true;
        do {
            try {
                System.out.println("Введите дробное число(для выхода введите - '-1'): ");
                res = sc.nextFloat();
                if(res == -1.0){
                    flag = false;
                }
                System.out.println("Ваше число - " + res);
            }catch (Exception e){
                System.out.println("Некорректный ввод!");
                sc.next();
            }
        }while (flag);
        sc.close();
        System.out.println("Всего доброго!");
    }
}
