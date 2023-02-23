package DynamicProgramming.DynamicProgramming1D;

public class MinStepsTo1 {

    public static int countSteps( int n )
    {
        if( n == 1 )
        {
            return 0;		// This is the base case. If we are already at one then we don't need to move
        }

        int op1= countSteps(n-1);
        int minSteps= op1;		// minSteps= ans


        if( n % 3 == 0 )
        {
            int op2= countSteps(n/3);

            if( op2 < minSteps )
            {
                minSteps= op2;
            }
        }

        if( n % 2 == 0 )
        {
            int op3= countSteps(n/2);

            if( op3 < minSteps )
            {
                minSteps= op3;
            }
        }

        return 1 + minSteps;

    }

    private static int countStepsM( int n , int storage[] )
    {
        if( n == 1 )
        {
            storage[n]= 0;
            return storage[n];
        }

        if( storage[n] != 0 )
        {
            return storage[n];
        }

        int op1= countStepsM(n-1, storage);
        int minSteps= op1;		// minSteps= ans


        if( n % 3 == 0 )
        {
            int op2= countStepsM(n/3, storage);

            if( op2 < minSteps )
            {
                minSteps= op2;
            }
        }

        if( n % 2 == 0 )
        {
            int op3= countStepsM(n/2, storage);

            if( op3 < minSteps )
            {
                minSteps= op3;
            }
        }

        storage[n]= 1 + minSteps;

        return storage[n];


    }

    public static int countStepsM( int n )
    {
        int storage[]= new int[n+1];

        return countStepsM(n, storage);
    }

    public static int countStepsDP( int n )
    {
        int storage[]= new int[n+1];

        storage[1]= 0;		// value we know

        for( int i= 2; i<= n; i++ )
        {
            int min= storage[i-1];    // op1

            if( i % 3 == 0 )
            {
                if( storage[i/3] < min )
                {
                    min= storage[i/3];		//op2
                }

            }

            if( i % 2 == 0 )
            {
                if( storage[i/2] < min )
                {
                    min= storage[i/2];		//op3
                }

            }

            storage[i]= 1 + min;

        }

        return storage[n];

    }

    public static void main(String[] args) {

        int n= 20;		// higher value of n to see significant time difference   keep  n < 800


        System.out.println(countStepsDP(n));
        System.out.println(countStepsM(n));

        int ans= countSteps(n);
        System.out.println(ans);

    }

}
