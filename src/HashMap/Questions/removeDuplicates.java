package HashMap.Questions;
import java.util.*;
public class removeDuplicates {

    public static ArrayList<Integer> removeDuplicatesUsingArray( int arr[] )
    {
        int max= arr[0];
        ArrayList<Integer> AR= new ArrayList<>();

        for( int i=1; i<arr.length; i++)
        {
            if( arr[i] > max )
            {
                max=arr[i];
            }
        }

        boolean bool[]= new boolean[max+1];
        bool[0]=true;


        for(int i=0; i<arr.length; i++)
        {
            if( bool[arr[i]] == false )
            {
                bool[arr[i]]= true;
                AR.add(arr[i]);
            }

        }


        return AR;
    }

    public static ArrayList<Integer> removeDuplicatesHM( int arr[] )
    {
        HashMap<Integer, Boolean> seen= new HashMap<>(); // stores what all we have seen
        ArrayList<Integer> output= new ArrayList<>();

        for( int i=0; i<arr.length; i++)
        {
            if( seen.containsKey(arr[i]))
            {
                continue;
            }
            else
            {
                seen.put(arr[i], true);
                output.add(arr[i]);
            }
        }

        return output;

    }

    public static void nonDuplicatesUsingHashMap( int arr[] )
    {
        HashMap<Integer,Integer> map= new HashMap<>();

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


        Set<Integer> set= map.keySet();
        System.out.println(set);

    }

    public static void main(String[] args) {

        int arr[]= {1,1,2,2,2,4,5,5,6,5,7,10,12};

        ArrayList<Integer> AR= new ArrayList<>();
        AR= removeDuplicatesHM(arr);
        System.out.println(AR);


        //nonDuplicatesUsingHashMap(arr);


    }

}

