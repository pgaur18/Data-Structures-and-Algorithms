package Queue.UsingArray;

public class QueueUsingArray {

    private int data[];
    private int front;
    private int rear;
    private int size;

    QueueUsingArray()
    {
        data= new int[10];
        front= -1;	// Queue is empty. Therefore -1. If we set front as 0 this means there is an element at front= 0 which is wrong.
        rear= -1;
        size= 0;
    }

    QueueUsingArray( int capacity )
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
            throw new QueueFullException();
        }

        if( size == 0 )
        {
            front= 0;
        }

        size++;

//		rear++;
//
//		if( rear == data.length )
//		{
//			rear= 0;
//		}

        rear= ( rear + 1 ) % data.length;		// Same in Dequeue
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
        size--;

        if( front == data.length )
        {
            front= 0;
        }

        if( size == 0 )
        {
            front= rear= -1;
        }

        return temp;

    }

}