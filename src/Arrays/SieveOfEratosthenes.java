package Arrays;
import java.util.*;

public class SieveOfEratosthenes {

    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);

        int i,j;
        System.out.println("Prime numbers till what number :");
        int n= sc.nextInt();

        int a[]= new int[n+1];

        for( i=0 ; i<=n ; i++)
        {

            a[i]=1;

        }


        a[0]=0;
        a[1]=0;

        for( i=2 ; i<=n ; i++)
        {
            if(a[i]==1)
            {
                for( j=2 ; i*j<=n ; j++)
                {
                    a[i*j]=0;
                }
            }

        }
        System.out.println("Prime numbers are :");

        for( i=2 ; i<=n ; i++)
        {
            if(a[i]==1)
            {
                System.out.println(i);
            }
        }

    }
}
