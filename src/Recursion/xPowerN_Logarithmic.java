package Recursion;
import java.util.*;

public class xPowerN_Logarithmic {

    public static int xPowerNLog( int n, int p)
    {
        if( p == 0 )
        {
            return 1;
        }

        int xpnb2= xPowerNLog( n, p/2 );
        int xn= xpnb2 * xpnb2;

        if( p%2 == 1)
        {
            xn*= n;
        }

        return xn;

    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter No and Power : ");
        int n= sc.nextInt();
        int p= sc.nextInt();

        int res=xPowerNLog( n, p );
        System.out.println(res);


    }

}
