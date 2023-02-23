package Arrays;

public class rotateArray {

    public static void rotateArrayByPositions( int arr[], int p )
    {
        p= p % arr.length;

        if( p < 0 )
        {
            p+= arr.length;
        }

        rotateHelper( arr, arr.length-p, arr.length-1);
        rotateHelper( arr, 0, arr.length-p-1 );
        rotateHelper( arr, 0, arr.length-1 );

    }


    public static void rotateHelper( int arr[], int lo, int hi )          // helps in rotating some part of array
    {
        while( lo < hi )
        {
            int temp= arr[lo];
            arr[lo]= arr[hi];
            arr[hi]= temp;

            lo++;
            hi--;
        }
    }

    public static void main(String[] args) {

        int arr[]= { 1,2,3,4,5 };

        for( int i : arr )
        {
            System.out.print(i+" ");
        }

        rotateArrayByPositions(arr, 2);
        System.out.println();

        for( int i : arr )
        {
            System.out.print(i+" ");
        }

    }

}
