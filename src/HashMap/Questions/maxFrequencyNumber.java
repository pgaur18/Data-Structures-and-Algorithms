package HashMap.Questions;

import java.util.*;

public class maxFrequencyNumber {

    public static void maxFrequency(int arr[] )
    {

        HashMap<Integer, Integer> map= new HashMap<>();

        for( int i : arr )
        {
            if( ! map.containsKey(i))
            {
                map.put(i, 1);
            }

            else
            {
                map.put(i, map.get(i)+1);
            }

        }

        int freq=0,no=0;

        for( int i : arr )
        {
            if( map.get(i) > freq )
            {
                freq= map.get(i);
                no= i;
            }
        }

        System.out.println(no+"'s frequency is : "+freq);



    }

    public static void main(String[] args) {

        int arr[]= { 1,2,3,2,4,4,1,4,5,6,4,7,4};

        maxFrequency( arr);
//		int maxFreq=  maxFrequency( arr );


    }

}

