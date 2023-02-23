package DynamicProgramming.DynamicProgramming1D;

public class staircase {

    public static int countStaircase( int n )
    {
        if( n < 0 )
        {
            return 0;
        }

        if( n == 0 )
        {
            return 1;
        }

        return countStaircase(n-1) + countStaircase(n-2) + countStaircase(n-3);
    }

    private static int countStaircaseM( int n, int storage[] )
    {
        if( n < 0 )
        {
            return 0;
        }

        if( n == 0 || n == 1 )
        {
            storage[n]= 1;
            return storage[n];
        }

        if( storage[n] != 0 )
        {
            return storage[n];
        }


        storage[n]=  countStaircaseM(n-1, storage) + countStaircaseM(n-2, storage) + countStaircaseM(n-3, storage);

        return storage[n];

    }

    public static int countStaircaseM( int n )
    {
        int storage[]= new int[n+1];

        return countStaircaseM(n, storage);

    }

    public static int countStaircasDP( int n )
    {
        if( n == 0 || n == 1 )	//  for n == 0 or n == 1, storage size will be 1 or 2 and we will try to access index 2 value that is below  ( storage[2] )
        {
            return 1;
        }

        int storage[]= new int[n+1];

        storage[0]= 1;
        storage[1]= 1;
        storage[2]= 2;

        for( int i= 3; i<=n; i++ )
        {
            storage[i]= storage[i-1] + storage[i-2] + storage[i-3];

        }

        return storage[n];

    }

    public static void main(String[] args) {

        int n= 50;

        System.out.println(countStaircasDP(n));

        System.out.println(countStaircaseM(n));

//		System.out.println(countStaircase(n));

    }

}
