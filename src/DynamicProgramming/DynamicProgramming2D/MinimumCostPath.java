package DynamicProgramming.DynamicProgramming2D;

import java.util.Arrays;

public class MinimumCostPath {

    private static int minCostPath( int arr[][], int i, int j )
    {
        int m= arr.length;
        int n= arr[0].length;

        if( i == m-1 && j == n-1 )		// Base case is when we reach the last cell
        {
            return arr[i][j];
        }

        if( i>= m || j >= n )
        {
            return Integer.MAX_VALUE;
        }

        int op1= minCostPath(arr, i+1, j);
        int op2= minCostPath(arr, i, j+1);
        int op3= minCostPath(arr, i+1, j+1);

        int min= Math.min( op1, Math.min(op2, op3));

        return min + arr[i][j];

    }

    public static int minCostPath( int arr[][] )
    {
        return minCostPath(arr, 0, 0);		// sending row start and column start

    }

    private static int minCostPathM( int arr[][], int i, int j, int storage[][] )
    {
        int m= arr.length;
        int n= arr[0].length;

        if( i == m-1 && j == n-1 )
        {
            storage[i][j]= arr[i][j];

            return storage[i][j];
        }

        if( i >= m || j >= n )
        {
            return Integer.MAX_VALUE;
        }

        if( storage[i][j] != -1 )
        {
            return storage[i][j];
        }

        int op1= minCostPathM(arr, i, j+1, storage);
        int op2= minCostPathM(arr, i+1, j+1, storage);
        int op3= minCostPathM(arr, i+1, j, storage);

        int min= Math.min(op1, Math.min(op2, op3));

        storage[i][j]= min + arr[i][j];

        return storage[i][j];

    }

    public static int minCostPathM( int arr[][] )
    {
        int storage[][]= new int[arr.length][arr[0].length];

        for( int i= 0; i< arr.length; i++ )
        {
            for( int j= 0; j< arr[0].length; j++ )
            {
                storage[i][j]= -1;
            }

        }

        return minCostPathM(arr, 0, 0, storage);

    }

    public static int minCostPathDP( int arr[][] )
    {
        int m= arr.length;
        int n= arr[0].length;

        int storage[][]= new int[arr.length][arr[0].length];

        storage[m-1][n-1]= arr[m-1][n-1]; 	// Last Cell


        // Filling last row and olum is our base case

        // Last Row

        for( int j= n-2; j>= 0; j-- )		// j= n-2 se start hoga kyoki initially n-1 cell( last cell ) toh bhara hua h.
        {
            storage[m-1][j]= storage[m-1][j+1] + arr[m-1][j];
        }

        // Last Column

        for( int i= m-2; i>= 0; i-- )
        {
            storage[i][n-1]= storage[i+1][n-1] + arr[i][n-1];
        }


        for( int i= m-2; i>= 0; i-- )
        {
            for( int j= n-2; j>= 0; j-- )
            {
                int min= Math.min(storage[i][j+1], Math.min(storage[i+1][j], storage[i+1][j+1]));

                storage[i][j]= min + arr[i][j];
            }

        }

        return storage[0][0];

    }

    public static void main(String[] args) {

        int arr[][]= { { 1,1,1 }, { 4,5,2 } , { 7,8,9 } };

        System.out.println(minCostPathDP(arr));
        System.out.println(minCostPathM(arr));
        System.out.println(minCostPath(arr));


    }

}
