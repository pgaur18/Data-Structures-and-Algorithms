package Arrays;

public class LargestAndSmallest {

    public static void printLargestAndSmallest( int arr[] )
    {
        int largest= Integer.MIN_VALUE;
        int smallest= Integer.MAX_VALUE;

        int i=0;

        while( i < arr.length )
        {
            if( arr[i] > largest )
            {
                largest= arr[i];
            }

            if( arr[i] < smallest )
            {
                smallest= arr[i];
            }

            i++;
        }

        System.out.println("Largest : "+ largest);
        System.out.println("Smallest : "+ smallest);

    }

    public static void main(String[] args) {

        int arr[]= { 1000, 11, 445, 1, 330, 3000 };  // We can solve it using sorting algorithm.
        // sort the array and return arr[0] and arr[arr.length-1] element.
        // But T.C= O(n*logn).

        printLargestAndSmallest(arr);    // T.C= O(n)   single traversal

    }
}
