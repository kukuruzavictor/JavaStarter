package com.company;

public class Bubble {
    public static void main (String[] args) {
        int [] number = {1,5,567,34,98,34,58,543,67,45,345,689,24,578,13,67,89};
        boolean isSorted=false;
        int k=1; // value to decrease the increment of every new inner cycle of bubble method

        System.out.print("          масив: ");
        for (int item : number) {
            System.out.print(item + " ");
        }

        //bubble method
        while (!isSorted) {
            isSorted=true;
            for (int i=0; i<number.length-k; i++) {
                if (number[i]>number[i+1]) {
                    // changing of value assertions without additional 3rd variable
                    number[i]+=number[i+1];
                    number[i+1]= number[i]-number[i+1];
                    number[i]=number[i]-number[i+1];
                    isSorted=false;
                }
            }
            k+=1;
        }

        System.out.print("\nметод бульбашки: ");
        for (int value : number) {
            System.out.print(value + " ");
        }

    }
}
