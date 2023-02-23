package Recursion;

import java.util.Scanner;

public class printIncreasing {

    public static void printInc( int n )
    {
        if(  n == 0 )
        {
            return;

        }

        printInc(n-1);
        System.out.print(n+" ");

    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.println("Enter n value : ");
        int n= sc.nextInt();

        printInc(n);

    }

}

