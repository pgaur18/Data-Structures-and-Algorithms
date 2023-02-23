package Priority_Queue;
import java.util.*;
public class our_Priority_Queue_Use {

    public static void insertIntoVirtualHeap( int arr[], int i)
    {
        int childIndex= i; // element that has to be inserted
        int parentIndex= ( childIndex-1 )/2;

        // UpHeapify- for maintaining heap order property

        while( childIndex > 0 )
        {
            if( arr[childIndex] < arr[parentIndex] )	// Min Heap
            {
                // Swap

                int temp= arr[childIndex];
                arr[childIndex]= arr[parentIndex];
                arr[parentIndex]= temp;

                childIndex= parentIndex;
                parentIndex= ( childIndex-1 )/2;

            }
            else
            {
                return;
            }

        }

    }

    public static int removeMinFromVirtualHeap(int arr[], int heapSize )
    {
        int ans= arr[0];
        arr[0]= arr[heapSize-1];
        heapSize--;		// reducing size to remove the last element. We used heap.remove(lastIndex)


        int index= 0;
        int minIndex= index;
        int leftChildIndex= 1;
        int rightChildIndex= 2;

        while( leftChildIndex < heapSize )
        {
            if( arr[leftChildIndex] < arr[minIndex])
            {
                minIndex= leftChildIndex;
            }
            if( rightChildIndex < heapSize && arr[rightChildIndex] < arr[minIndex] )
            {
                minIndex= rightChildIndex;
            }

            if( minIndex == index )
            {
                break;
            }

            else
            {
                int temp= arr[index];
                arr[index]= arr[minIndex];
                arr[minIndex]= temp;

                index= minIndex;
                leftChildIndex= 2*index + 1;
                rightChildIndex= 2*index + 2;

            }


        }

        return ans;

    }

    public static void kSortedArray( int arr[], int k )
    {
        PriorityQueue<Integer> pq= new PriorityQueue<>();

        int i= 0;
        for( ; i<k; i++ )		// inserting first k elements in our PQ
        {
            pq.add(arr[i]);
        }

        for( ; i<arr.length; i++ )		// first 3 elements of array is sorted
        {
            arr[i-k]= pq.remove();
            pq.add(arr[i]);

        }

        for( int j= arr.length-k; j< arr.length; j++ )
        {
            arr[j]= pq.remove();
        }

    }

    public static void main(String[] args) throws PriorityQueueException  {
        // TODO Auto-generated method stub

//		Priority_Queue_Min pq= new Priority_Queue_Min();

//		int arr[]= { 5, 1, 9, 2, 0 };
//
//		for( int i : arr )
//		{
//			pq.insert(i);
//		}
//
//		while( ! pq.isEmpty() )
//		{
//			System.out.print( pq.remove() + ", " );
//		}
//
//		System.out.println();
//
//		int arr[]= { 5, 1, 9, 2, 0, 6};
//
//		for( int i= 0; i<arr.length; i++ )
//		{
//			insertIntoVirtualHeap(arr, i);		// Making changes to the same array
//									// we have to insert i th element of arr in the Virtual Heap
//		}
//
//		for( int i : arr )
//		{
//			System.out.print(i + ", ");
//		}
//
//		System.out.println();
//
//		// Removing elements
//		for( int i= 0; i<arr.length; i++ )
//		{
//			arr[arr.length-1-i]= removeMinFromVirtualHeap(arr, arr.length-i);
//										// We need size of the heap to get the last element.  heap.get()
//										// Therefore we will pass size of the virtualheap here
//										// arr.length-i is done because the size of the the heap will reduce when we remove element
//										//  because first element is replaced by last element of the heap.
//		}
//
//		// Sorted but in descending order
//
//		System.out.println("Sorted in Descending Order");
//
//		for( int i : arr )
//		{
//			System.out.print(i + ", " );
//		}

        int arr[]= { 2, 4, 1, 9, 6, 8   };
        int k= 3;

        kSortedArray(arr, k);

        for( int i : arr )
        {
            System.out.print(i + ", ");
        }

    }

}

