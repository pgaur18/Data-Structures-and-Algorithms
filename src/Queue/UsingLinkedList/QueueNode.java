package Queue.UsingLinkedList;

public class QueueNode<T> {

    T data;
    QueueNode<T> next;

    QueueNode( T data )
    {
        this.data= data;
        this.next= null;
    }

}
