package Array_Sorting;

public class SelectionSort {

    public static void main(String[] args) {

        int i,j;
        int min,temp;

        int a[]= {34,31,66,-78,-89};

        for(i=0; i<4; i++)
        {
            min = i;
            for(j=i+1; j<5; j++)
            {
                if( a[min]> a[j] )
                {
                    min= j;
                }
            }

            temp= a[i];
            a[i]=a[min];
            a[min]=temp;

        }


        System.out.println("Sorted array :");

        for(i=0; i<5; i++)
        {
            System.out.print(a[i]+" ");
        }

    }
}
