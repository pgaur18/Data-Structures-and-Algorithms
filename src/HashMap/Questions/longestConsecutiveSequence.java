package HashMap.Questions;

import java.util.*;

public class longestConsecutiveSequence {

    public static ArrayList<Integer> Helper( int arr[] )
    {
        HashMap<Integer,Boolean> map= new HashMap<>();

        for(int key : arr )
        {
            map.put(key,true);
        }

        ArrayList<Integer> maxArray = new ArrayList<>();
        int max= Integer.MIN_VALUE;	// length

        for( int key : arr )
        {
            ArrayList<Integer> array= new ArrayList<>();

            if( map.get(key) == true )
            {
                while(map.containsKey(key))	//if we dont go over any consecutive num, map will not contain it.
                {
                    array.add(key);
                    map.put(key,false);
                    key=key+1;
                }

                while(map.containsKey(key))
                {
                    array.add(key);
                    map.put(key,false);
                    key=key-1;
                }

                if(array.size()>max)
                {
                    max=array.size();
                    maxArray=array;
                }

            }

        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(maxArray.get(0));
        ans.add(maxArray.get(max-1));

        return ans;

    }

    public static void main(String[] args) {


        int arr[]= { 3, 7, 2, 1, 9, 8, 41 };

        ArrayList<Integer> ar= Helper(arr);

        System.out.println(ar);


    }

}