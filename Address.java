package com.company;

import java.util.Scanner;

public class Address {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.print("Enter your name (format: Name Surname): ");
        input = sc.nextLine();
        while (!input.trim().matches("[A-Za-z]+ [A-Za-z]+( [A-Za-z]+)?")){
            System.out.print("WRONG FORMAT. Try again: ");
            input = sc.nextLine();
        }
        String name = input;
        System.out.print("Enter your address (example: Street, #/#, city): ");
        input = sc.nextLine();
        while (!input.trim().matches("([0-9A-Za-z -]+,( )?)([0-9]+([A-Za-z])?(/[0-9]+)?),( )?([A-Za-z -]+)")){
            System.out.print("WRONG FORMAT. Try again: ");
            input = sc.nextLine();
        }
        String address = input;
        System.out.print("Enter your index (format: 12345): ");
        input = sc.nextLine();
        while (!input.trim().matches("[0-9]{5}")){
            System.out.print("WRONG FORMAT. Try again: ");
            input = sc.nextLine();
        }
        String index = input;

        System.out.println("THANKS!");
        System.out.println("NAME: "+name);
        System.out.println("ADDRESS: "+address);
        System.out.println("INDEX: "+index);
    }
}
