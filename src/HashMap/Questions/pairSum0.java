package HashMap.Questions;

import java.util.*;

public class pairSum0 {

    public static void countPair( int arr[] )
    {
        HashMap<Integer, Integer> map= new HashMap<>();

        //Arrays.sort(arr);
        int count=0;

        for( int i=0; i<arr.length; i++ )
        {
            if( map.containsKey(-arr[i]))
            {
                count+= map.get(-arr[i]);
            }

            if( ! map.containsKey(arr[i]) )
            {
                map.put(arr[i], 1);
            }

            else
            {
                map.put(arr[i], map.get(arr[i]) +1);
            }

        }

        System.out.println("Total pair are: "+count);

    }

    public static void main(String[] args) {

        int arr[]= { -1,1,-1,1,1,-1,1};

        countPair(arr);

//		Pair<Integer,Integer> p1[]= new Pair[10];

    }

}

