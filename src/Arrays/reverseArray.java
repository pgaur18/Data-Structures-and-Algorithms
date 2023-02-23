package Arrays;

public class reverseArray {

    // Iterative Solution
    public static void reverseArray1( int arr[] )
    {
        int lo=0;
        int hi=arr.length-1;

        while( lo < hi )
        {
            int temp= arr[lo];
            arr[lo]= arr[hi];
            arr[hi]= temp;

            lo++;
            hi--;
        }

    }

    // Recursive Solution
    public static void reverseArray2( int arr[], int lo, int hi )
    {
        // Base Case
        if( lo >= hi )
        {
            return;
        }

        int temp= arr[lo];
        arr[lo]= arr[hi];
        arr[hi]= temp;

        reverseArray2(arr, lo+1, hi-1);

    }

    public static void main(String[] args) {

        int arr[]= { 1,2,3,4,5,6 };

        // You can use anyone of the method to reverse the Array.

        reverseArray1(arr);
        //reverseArray2(arr, 0, 5);

        for( int i=0; i<arr.length; i++ )
        {
            System.out.print(arr[i]+" ");
        }

    }
}
