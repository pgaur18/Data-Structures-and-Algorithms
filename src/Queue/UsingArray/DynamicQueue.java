package Queue.UsingArray;

public class DynamicQueue {

    private int data[];
    private int front;
    private int rear;
    private int size;

    DynamicQueue()
    {
        data= new int[10];
        front= -1;	// Queue is empty. Therefore -1. If we set front as 0 this means there is an element at front= 0 which is wrong.
        rear= -1;
        size= 0;
    }

    DynamicQueue( int capacity )
    {
        data= new int[capacity];
        front= -1;	// Queue is empty. Therefore -1. If we set front as 0 this means there is an element at front= 0 which is wrong.
        rear= -1;
        size= 0;
    }


    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        if( size == 0 )
        {
            return true;
        }

        return false;

//		return size == 0 ? true : false;

    }

    public int Front() throws QueueEmptyException
    {
        if( size == 0 )
        {
            throw new QueueEmptyException();
        }

        return data[front];

    }

    public void Enqueue( int element ) throws QueueFullException
    {
        if( size == data.length )
        {
//			throw new QueueFullException();
            DoubleCapacity();
        }

        if( size == 0 )
        {
            front= 0;
        }

        size++;
        rear= ( rear + 1 ) % data.length;		// Same in Dequeue

//		rear++;
//
//		if( rear == data.length )
//		{
//			rear= 0;
//		}

        data[rear]= element;

    }

    public int Dequeue() throws QueueEmptyException
    {
        if( size == 0 )
        {
            throw new QueueEmptyException();
        }

        int temp= data[front];
        front++;

        if( front == data.length )
        {
            front= 0;
        }

        size--;

        if( size == 0 )
        {
            front= rear= -1;
        }

        return temp;

    }

    private void DoubleCapacity()
    {
        int temp[]= data;

        data= new int[ 2* temp.length];
        int index= 0;

        for( int i= front; i< temp.length; i++ )
        {
            data[index]= temp[i];
            index++;
        }

        for( int i= 0; i<= front-1; i++ )
        {
            data[index]= temp[i];
            index++;

        }

        front= 0;		// Front and rear will also be rearranged
        rear= temp.length-1;

    }


}
