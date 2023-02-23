package Arrays;

public class secondLargestElement {

    public static int secondLargest( int arr[] )
    {
        int max= Integer.MIN_VALUE;
        int smax= Integer.MIN_VALUE;

        for( int i=0; i< arr.length; i++ )
        {
            if( arr[i] > max )
            {
                smax= max;
                max= arr[i];
            }
            else if ( arr[i] < max && arr[i] > smax )
            {
                smax= arr[i];
            }
            else
            {

            }

        }

        return smax;
    }

    public static void main(String[] args) {

        int arr[]= { 5,4,3,2,1,9 };
        int n= secondLargest( arr );
        System.out.println("Second laregest element is : " + n);

    }

}
