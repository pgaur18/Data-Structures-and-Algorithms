package DynamicProgramming.DynamicProgramming1D;

import java.util.Arrays;

public class fibonacci {

    public static int fib( int n )
    {
        if( n == 0 || n == 1)
        {
            return n;
        }

        return fib(n-1) + fib(n-2);

    }

    public static int fibM( int n )		// M stands for memoization
    {
        int storage[]= new int[n+1];
        Arrays.fill(storage, -1);

//		We need one more method for recursive call
//		fibM( int n, int storage[] )

        return fibM(n, storage);

    }

    public static int fibM( int n, int storage[] )
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

        storage[n]= fibM(n-1, storage) + fibM(n-2, storage);

        return storage[n];

    }

    public static int fibDP( int n )
    {
        int storage[]= new int[n+1];

        storage[0]= 0;	// base case
        storage[1]= 1;	// base case

        for( int i= 2; i< storage.length; i++ )
        {
            storage[i]= storage[i-1] + storage[i-2];
        }

        return storage[n];	 // last element

    }

    public static void main(String[] args) {

        int n= 44; 		// n == 44 to see the time difference between the 2 approaches

        System.out.println(fibDP(n));

        System.out.println(fibM(n));

        int ans= fib(n);
        System.out.println(ans);

    }

}
