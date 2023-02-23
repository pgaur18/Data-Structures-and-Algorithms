package LinkedList;

public class Node<T> {

    T data;
    Node<T> next;  // next will store address of what ?? address of next node therefore its type( data type ) will be Node.

    public Node( T data )
    {
        this.data= data;
        this.next= null;
    }

}