package HashMap.Questions;
import java.util.*;
public class Intersection_of_Arrays {

    public static void printIntersection( int arr1[], int arr2[] )
    {
        HashMap<Integer,Integer> map= new HashMap<>();

        for( int i : arr1 )
        {
            if( ! map.containsKey(i) )
            {
                map.put(i, 1);
            }

            else
            {
                map.put(i, map.get(i)+1);
            }

        }

        Arrays.sort(arr2);     // prints the no in increasing order

        for( int i : arr2 )
        {
            if( map.containsKey(i) && (map.get(i) > 0 ))
            {
                System.out.print(i+" ");
                map.put(i, map.get(i)-1);      // reduces the count of particular numbers
                // put method updates the previous value
            }								   // because key is already present in the hashmap

        }

    }
    public static void main(String[] args) {

        int arr1[]= {1,2,3,4,5,6,7,8};
        int arr2[]= {2,4,6,8,10};

        printIntersection(arr1, arr2);

    }

}
