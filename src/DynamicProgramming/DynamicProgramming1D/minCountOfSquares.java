package DynamicProgramming.DynamicProgramming1D;
import java.util.*;
public class minCountOfSquares {

    public static int countMin( int n )
    {
        if( n == 0 )
        {
            return 0;
        }

        int min=Integer.MAX_VALUE;

        for(int i=1; i*i<= n; i++)
        {
            int curr= countMin(n-(i*i));

            if( curr < min )
            {
                min= curr;
            }

        }

        return 1 + min;

    }

    private static int countMinM( int n , int storage[] )
    {
        if( n == 0 || n == 1 )
        {
            storage[n]= n;
            return storage[n];
        }

        if( storage[n] != -1 )
        {
            return storage[n];
        }

        int min= Integer.MAX_VALUE;

        for( int i= 1; i*i<= n; i++ )
        {
            int smallAns= countMinM(n-(i*i), storage);

            if( smallAns < min )
            {
                min= smallAns;
            }

        }

        storage[n]= 1 + min;

        return storage[n];

    }

    public static int countMinM( int n )
    {
        int storage[]= new int[n+1];

        Arrays.fill(storage, -1);		// if it is -1 that means it is not calculated yet

        return countMinM(n, storage);

    }
    public static int countMinDP( int n )
    {
        int storage[]= new int[n+1];

        storage[0]= 0;
        storage[1]= 1;
        storage[2]= 2;
        storage[3]= 3;

        for( int i= 4; i<= n ; i++ )
        {
            int min= Integer.MAX_VALUE;

            for( int j= 1; j*j<= i; j++ )
            {
                int curr= storage[n-(j*j)];

                if( curr < min )
                {
                    min= curr;
                }
            }

            storage[n]= 1 + min;

        }

        return storage[n];

    }

    public static void main(String[] args) {

        int n= 100;

        System.out.println(countMinM(n));
        System.out.println(countMin(n));


    }

}
