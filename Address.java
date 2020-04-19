package com.company;

import java.util.Scanner;

public class Address {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.print("Enter your name (format: Name Surname): ");
        input = sc.nextLine();
        while (!nameCheck(input)){
            System.out.print("WRONG FORMAT. Try again: ");
            input = sc.nextLine();
        }
        String name = input;

        System.out.print("Enter your address (example: Street, #/#, city): ");
        input = sc.nextLine();
        while (!addressCheck(input)){
            System.out.print("WRONG FORMAT. Try again: ");
            input = sc.nextLine();
        }
        String address = input;

        System.out.print("Enter your index (format: 12345): ");
        input = sc.nextLine();
        while (!indexCheck(input)){
            System.out.print("WRONG FORMAT. Try again: ");
            input = sc.nextLine();
        }
        String index = input;

        System.out.println("THANKS!");
        System.out.println("NAME: "+name);
        System.out.println("ADDRESS: "+address);
        System.out.println("INDEX: "+index);
    }

    public static boolean nameCheck (String str){
        if (str.trim().matches("[A-Za-z]+ [A-Za-z]+( [A-Za-z]+)?")){
            return true;
        }
        return false;
    }
    public static boolean addressCheck (String str){
        if (str.trim().matches("([0-9A-Za-z -]+,( )?)([0-9]+([A-Za-z])?(/[0-9]+)?),( )?([A-Za-z -]+)")){
            return true;
        }
        return false;
    }
    public static boolean indexCheck (String str){
        if (str.trim().matches("[0-9]{5}")){
            return true;
        }
        return false;
    }


}
