package Recursion;
import java.util.*;
public class xPowerN {

    public static int xPowerN( int n, int m )
    {
        if( m == 0 )
        {
            return 1;
        }

        return n* xPowerN(n , m-1 );


    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter No and Power : ");
        int n= sc.nextInt();
        int m= sc.nextInt();

        int res= xPowerN( n, m);
        System.out.println( res );

    }


}
