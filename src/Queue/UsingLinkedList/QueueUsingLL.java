package Queue.UsingLinkedList;

public class QueueUsingLL<T> {

    private QueueNode<T> front;
    private QueueNode<T> rear;
    private int size;

    QueueUsingLL()
    {
        front= null;
        rear= null;
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

    }

    public T Front() throws EmptyQueueException
    {
        if( front == null )
        {
            throw new EmptyQueueException();
        }

        return front.data;
    }

    public void Enqueue( T element )
    {
        QueueNode<T> newNode= new QueueNode<>(element);
        size++;

        if( front == null )
        {
            front= rear= newNode;
            return;
        }

        rear.next= newNode;
        rear= newNode;

    }

    public T Dequeue() throws EmptyQueueException
    {
        if( front == null )
        {
            throw new EmptyQueueException();
        }

        T ans= front.data;
        front= front.next;
        size--;
        return ans;

    }

}
