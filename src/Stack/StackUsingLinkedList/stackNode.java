package Stack.StackUsingLinkedList;

public class stackNode<T> {

    T data;
    stackNode<T> next;

    stackNode( T data )
    {
        this.data= data;
        this.next= null;
    }

}