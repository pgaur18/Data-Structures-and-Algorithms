package Priority_Queue;


import java.util.*;


class MinPQComparator implements Comparator<Integer>
{
    @Override
    public int compare(Integer o1, Integer o2) {
        // TODO Auto-generated method stub

        if( o1 < o2 )
        {
            return -1;
        }
        if( o1 > o2 )
        {
            return 1;
        }

        return 0;

    }

}

class MaxPQComparator implements Comparator<Integer>
{

    @Override
    public int compare(Integer o1, Integer o2) {
        // TODO Auto-generated method stub

        if( o1 < o2 )
        {
            return 1;
        }
        if( o1 > o2 )
        {
            return -1;
        }

        return 0;

    }

}

class MinStringLengthComparator implements Comparator<String>
{

    @Override
    public int compare(String o1, String o2) {

        if( o1.length() < o2.length() )
        {
            return -1;
        }
        if( o1.length() > o2.length() )
        {
            return 1;
        }

        return 0;

    }

}

class MaxStringLengthComparator implements Comparator<String>
{

    @Override
    public int compare(String o1, String o2) {

        if( o1.length() < o2.length() )
        {
            return 1;
        }
        if( o1.length() > o2.length() )
        {
            return -1;
        }

        return 0;

    }

}


public class Priority_Queue_Implementation {

    public static void main(String[] args) {

//		MinPQComparator minPQ= new MinPQComparator();

//		MaxPQComparator maxPQ= new MaxPQComparator();
//
//		PriorityQueue<Integer> pq= new PriorityQueue<>(maxPQ);
//
//		int arr[]= { 9, 1, 0, 4, 7, 3 };
//
//		for( int i : arr )
//		{
//			pq.add(i);
//		}
//
//		while( ! pq.isEmpty() )
//		{
//			System.out.print(pq.remove() + ", ");
//		}


        String words[]= { "this", "at", "a", "their", "queues" };

//		MinStringLengthComparator minlength= new MinStringLengthComparator();
//		PriorityQueue<String> minpq= new PriorityQueue(minlength);
//
//
//		for( String s : words )
//		{
//			minpq.add(s);
//		}
//
//		while( ! minpq.isEmpty() )
//		{
//			System.out.print(minpq.remove() + ", ");
//		}
//
//		System.out.println();
//
//		MaxStringLengthComparator maxlength= new MaxStringLengthComparator();
//		PriorityQueue<String> maxpq= new PriorityQueue(maxlength);
//
//
//		for( String s : words )
//		{
//			maxpq.add(s);
//		}
//
//		while( ! maxpq.isEmpty() )
//		{
//			System.out.print(maxpq.remove() + ", ");
//		}


//		PriorityQueue<String> maxPQ= new PriorityQueue<>(Collections.reverseOrder());
//
//		for( String s : words )
//		{
//			maxPQ.add(s);
//		}
//
//		while( ! maxPQ.isEmpty() )
//		{
//			System.out.print(maxPQ.remove() + ", ");
//		}


        PriorityQueue<Integer> maxPQ= new PriorityQueue<>(Collections.reverseOrder());

        maxPQ.add(1);
        maxPQ.add(2);
        maxPQ.add(3);
        maxPQ.add(4);
        maxPQ.add(5);

        while( ! maxPQ.isEmpty() )
        {
            System.out.print(maxPQ.remove() + ", ");
        }

    }

}
