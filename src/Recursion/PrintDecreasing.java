package Recursion;
import java.util.*;
public class PrintDecreasing {

    public static void printD( int n )
    {
        if( n == 0 )
        {
            return;

        }

        System.out.println(n);
        printD(n-1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n= sc.nextInt();

        printD(n);

    }


}
