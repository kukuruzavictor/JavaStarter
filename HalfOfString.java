package com.company;

import java.util.Scanner;

public class HalfOfString {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть рядок: ");
        String string = sc.nextLine();
        System.out.println("Рядок:     "+string);
        System.out.println("Пів рядка: "+halfString(string));

    }

    public static String halfString(String string){
        return string.substring(0, string.length()/2);
    }
}
