package Recursion;
import java.util.*;
public class all_Indices {

    public static int[] allIndices( int arr[], int idx ,int x, int fsf )
    {
        if( idx == arr.length )
        {
            return new int[fsf];
        }

        if( arr[idx] == x )
        {
            int all[]= allIndices(arr, idx+1, x, fsf+1);
            all[fsf]=idx;
            return all;
        }

        else
        {
            int all[]= allIndices(arr, idx+1, x, fsf);
            return all;
        }

    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();

        int arr[]= new int[n];

        for( int i=0; i<n; i++)
        {
            arr[i]= sc.nextInt();
        }
        System.out.println("Enter data value : ");
        int x = sc.nextInt();

        int res[]=allIndices(arr,0, x, 0);

        for( int i=0; i<res.length; i++ )
        {
            System.out.print(res[i]+" ");
        }

    }

}
