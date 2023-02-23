package Array_Sorting;
import java.util.*;

public class Bubble_Sort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a[] = new int [5];

        int i,j;
        int f=0;
        System.out.println("Enter array elements :");

        for(i=0; i<5; i++)
        {
            a[i] = sc.nextInt();
        }

        for(i=0; i<4; i++)    // rounds = n-1  //   n= number of elements
        {
            for(j=0; j<4-i; j++)
            {
                if ( a[j] > a[j+1] )
                {
                    int t = a[j];
                    a[j]= a[j+1];
                    a[j+1]= t;
                    f=1;
                }
            }

            if(f==0)
            {
                System.out.println("array already sorted");
                break;
            }
        }
        System.out.println("Sorted array is :");

        for(i=0; i<5; i++)
        {
            System.out.print(a[i]+" ");
        }

    }
}
