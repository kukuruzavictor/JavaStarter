package com.company;

public class Bubble {

    public static void main (String [] args){
        int [] array = arrayGenerator();
        System.out.print("        Generated array: | ");
        printArray(array);
        System.out.print("Sorted by BUBBLE method: | ");
        printArray(bubble(array));
    }

    public static int [] bubble (int [] array){
        boolean isSorted = false;
        int k = 1; // value to decrease the increment of every new inner cycle of bubble method
        while (!isSorted){
            isSorted=true;
            for (int i=0; i<array.length-k; i++){
                if (array[i]>array[i+1]){
                    array[i]+=array[i+1];
                    array[i+1]=array[i]-array[i+1];
                    array[i]=array[i]-array[i+1];
                    isSorted=false;
                }
            }
            k+=1;
        }
        return array;
    }

    public static int[] arrayGenerator(){
        int arrayLength = (int) (5 + (Math.random()*(16)));
        int [] array = new int[arrayLength];
        for (int i=0; i<array.length; i++){
            array[i] = (int) (Math.random()*(1000));
        }
        return array;
    }

    public static void printArray(int[] array){
        for (int value: array) {
            System.out.print(value+" ");
        }
        System.out.println();
    }
}
