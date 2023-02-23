package Arrays;
import java.util.*;
public class majorityElement {

    public static int majorityElement(int arr[] )
    {
        int major= -1;
        int majorCount= -1;

        if( arr.length == 1 )
        {
            return arr[0];
        }

        Arrays.sort(arr);   // Increase T.C to ( n*logn ) from O(n)
        // used for just sysout() purpose

//        for( int i : arr )
//        {
//        	System.out.print(i+ " ");
//        }

//        System.out.println();

        HashMap<Integer, Integer> map= new HashMap<>();

        for( int i=0; i< arr.length; i++ )
        {
            if( ! map.containsKey( arr[i] ) )
            {
                map.put( arr[i], 1 );
            }
            else
            {
                map.put( arr[i], map.get( arr[i]) + 1 );

                if( map.get( arr[i] ) == majorCount )
                {
                    major= -1;
                }

                if( map.get( arr[i] ) > majorCount )
                {
                    major= arr[i];
                    majorCount= map.get( arr[i] );
                }

            }

        }

        if( major == -1 )
        {
            majorCount= -1;
        }

        return major;

    }

    public static void main(String[] args) {

        int arr[]= { 6, 1, 15, 19, 9, 13, 12, 6, 7, 2, 10, 4, 1, 14, 11, 14, 14, 13 };

//		int arr[]= { 15 };
        System.out.println(majorityElement(arr));

    }

}
