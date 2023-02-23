package Priority_Queue;

import java.util.*;

public class Priority_Queue_Min {

    private ArrayList<Integer> heap;

    public Priority_Queue_Min()
    {
        heap= new ArrayList<>();
    }

    public boolean isEmpty()
    {
        return heap.size() == 0;
    }

    public int size()
    {
        return heap.size();
    }

    public int getMin() throws PriorityQueueException
    {
        if( heap.size() == 0  )		// isEmpty can also be used
        {
            throw new PriorityQueueException();
        }

        return heap.get(0);		// If list is not empty
    }

    public void insert( int element )
    {
        heap.add(element);

        int childIndex= heap.size()-1;
        int parentIndex= ( childIndex-1 )/2;

        // UpHeapify- for maintaining heap order property

        while( childIndex > 0 )
        {
            if( heap.get(childIndex) < heap.get(parentIndex) )	// Min Heap
            {
                // Swap

                int temp= heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex= parentIndex;
                parentIndex= ( childIndex-1 )/2;

            }
            else
            {
                return;
            }

        }

    }

    public int remove() throws PriorityQueueException
    {
        if( heap.size() == 0 )
        {
            throw new PriorityQueueException();
        }

        int ans= heap.get(0);

        int lastIndex= heap.size()-1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);

        int index= 0;
        int minIndex= index;
        int leftChildIndex= 1;	// initially    2*index+ 1= 1;
        int rightChildIndex= 2;	// initially	2*index+ 2= 2;

        // Down Heapify

        while(  leftChildIndex < heap.size() )
        {
            if( heap.get(leftChildIndex) < heap.get(minIndex) )
            {
                minIndex= leftChildIndex;
            }

            if( rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex) ) // if left child exists and right childchild does not exits then rightChildIndex is out of bound
            {																				   // for leftChildIndex, we are checking this condition in the while loop
                minIndex= rightChildIndex;
            }

            if( minIndex == index )
            {
                break;
            }
            else
            {
                int temp= heap.get(index);
                heap.set(index, heap.get(minIndex));
                heap.set(minIndex, temp);

                index= minIndex;
                leftChildIndex= 2*index + 1;
                rightChildIndex= 2*index + 2;

            }

        }

        return ans;

    }


}
