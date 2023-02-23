package Array_Sorting;

public class InsertionSort {

    public static void main(String[] args) {

        int i,j;

        int temp=0;

        int a[]= {3,1,5,2,10};

        for(i=1; i<5; i++)
        {
            temp=a[i];
            j=i;

            while( j>0 && a[j-1]>temp)
            {
                a[j]= a[j-1];
                j--;

            }

            a[j]=temp;

        }
        System.out.println("Sorted array is");
        for(i=0; i<5; i++)
        {

            System.out.print(a[i]+" ");
        }

    }

}
