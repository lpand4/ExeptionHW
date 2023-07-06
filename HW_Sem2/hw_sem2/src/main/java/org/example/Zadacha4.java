package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Zadacha4 {
    public static void main(String[] args) {
        //Разработайте программу,
        // которая выбросит Exception, когда пользователь вводит пустую строку.
        // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

        System.out.println(inputStr());
    }
    public static String inputStr(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку, которую хотите видеть на экране: ");
        String res = sc.nextLine();
        int count = 0;
        for (char ch : res.toCharArray()) {
            if(ch == ' '){
                count++;
            }
        }
        if(res.length() == count || res.equals("")){
            throw new RuntimeException("Пустые строки вводить нельзя");
        }
        return res;
    }
}
