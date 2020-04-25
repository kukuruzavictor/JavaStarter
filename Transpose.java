package com.company;

public class Transpose {
    public static void main (String[] args) {

        int n=10;
        int[][] arr = new int[n][n];
        int buffer;

        for(int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j]=(n*i+j)+1;
            }
        }

        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr[i].length; j++) {
                buffer=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=buffer;
            }

        }

        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
