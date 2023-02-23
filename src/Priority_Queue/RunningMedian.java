package Priority_Queue;

import java.util.*;

public class RunningMedian {

    public static void main(String[] args) {

        int arr[]= { 7, 2, 8, 3, 1, 5 };

        PriorityQueue<Integer> min= new PriorityQueue<>();
        PriorityQueue<Integer> max= new PriorityQueue<>(Collections.reverseOrder()) ;

        if( arr.length == 0 )
        {
            return;
        }

        max.add(arr[0]);

        System.out.print(arr[0] + " ");

        for( int i= 1; i< arr.length; i++ )
        {
            if( arr[i] < max.peek() )
            {
                max.add(arr[i]);
            }

            else
            {
                min.add(arr[i]);
            }

            if( max.size() - min.size() > 1 )
            {
                min.add(max.remove());
            }
            else if( min.size() - max.size() > 1 )
            {
                max.add(min.remove());
            }


            int n = min.size() + max.size();

            if( n % 2 != 0 )
            {
                if( max.size() > min.size() )
                {
                    System.out.print(max.peek() + " ");
                }
                else
                {
                    System.out.print(min.peek() + " ");
                }

            }

            else
            {
                int ans= ( max.peek() + min.peek() )/2;

                System.out.print(ans + " ");
            }

        }


    }

}
