package DynamicProgramming.DynamicProgramming2D;

import java.util.*;

public class Knapsack {

    private static int knapsack( int weights[], int values[], int maxWeight, int i )
    {
        if( i == weights.length || maxWeight == 0 )
        {
            return 0;
        }

        if( weights[i] > maxWeight )
        {
            return knapsack( weights, values, maxWeight, i+1 );
        }
        else
        {
            int op1= values[i] + knapsack( weights, values, maxWeight - weights[i], i+1 );	// item include
            int op2= knapsack( weights, values, maxWeight, i+1 );	// item not included

            return Math.max(op1, op2);

        }

    }

    public static int knapsack( int weights[], int values[], int maxWeight )
    {
        return knapsack(weights, values, maxWeight, 0);		// 0 is the index from where we started picking our items.
    }

    private static int knapsackM( int weights[], int values[],int maxWeight, int storage[][], int i )
    {
        int m= i;
        int n= maxWeight;

        if( i == weights.length || maxWeight == 0 )
        {
            storage[m][n]= 0;
            return storage[m][n];
        }

        if( storage[m][n] != -1 )
        {
            return storage[m][n];
        }

        if( weights[i] > maxWeight )
        {
            storage[m][n]= knapsackM(weights, values, maxWeight, storage, i+1);

            return storage[m][n];

        }

        else
        {
            int op1= values[i] + knapsackM(weights, values, maxWeight-weights[i], storage, i+1);
            int op2= knapsackM(weights, values, maxWeight, storage, i+1);

            storage[m][n]= Math.max(op1, op2);

            return storage[m][n];

        }


    }

    public static int knapsackM( int weights[], int values[], int maxWeight)
    {
        int n= weights.length;

        int storage[][]= new int[n+1][maxWeight+1];

        for( int i= 0; i<= n; i++ )
        {
            for( int j= 0; j<= maxWeight; j++ )
            {
                storage[i][j]= -1;
            }

        }

        return knapsackM( weights, values, maxWeight, storage, 0);

    }

    public static void main(String[] args) {

        int weights[]= {6, 1, 2, 4, 5};
        int values[]= {10, 5, 4, 8, 6};

        int maxWeight= 5;

        System.out.println(knapsack(weights, values, maxWeight));
        System.out.println(knapsackM(weights, values, maxWeight));


    }

}
