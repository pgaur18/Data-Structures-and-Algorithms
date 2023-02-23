package LinkedList.Implementation;
import java.util.*;

public class linkedListClass<T> {

    static Scanner sc= new Scanner(System.in);

    static Node<Integer> head;
    static Node<Integer> tail;
    static int size;

    public void takeInputAddFirst()
    {
        System.out.println("Enter data : ");
        int n = sc.nextInt();

        while( n != -1 )
        {
            addFirst(n);

            System.out.println("Enter next data : ");
            n= sc.nextInt();
        }

    }

    public void takeInputAddLast()
    {
        System.out.println("Enter data : ");
        int n = sc.nextInt();

        while( n != -1 )
        {
            addLast(n);

            System.out.println("Enter next data : ");
            n= sc.nextInt();

        }

    }

    private Node<Integer> addFirst( int value )
    {
        Node<Integer> node= new Node<>(value);
        size++;

        if( head == null )
        {
            head= tail= node;

        }

        else
        {
            node.next= head;
            head= node;

        }

        return head;

    }

    private Node<Integer> addLast( int value )
    {
        Node<Integer> node= new Node<>(value);
        size++;

        if( head == null )
        {
            head= tail= node;
        }

        else
        {
            tail.next= node;
            tail= node;

        }

        return head;

    }

    public int Size()
    {
        return size;
    }

    public void display( )
    {
        if( head == null )
        {
            return;
        }

        while( head != null )
        {
            System.out.print(head.data+ ", ");
            head= head.next;
        }

        System.out.println();

    }

    public void deleteFirst()
    {
        if( head == null )
        {
            return;
        }

        if( head == tail )
        {
            head= tail= null;
            return;
        }

        head= head.next;

    }

    public void deleteLast()
    {
        if( head == null )
        {
            return;
        }

        if( head == tail )
        {
            System.out.println("No deleted is : "+ head.data);
            head= tail= null;
            return;
        }

        Node<Integer> temp= head;

        while( temp.next.next != null )
        {
            temp= temp.next;
        }

        temp.next= null;
        tail= temp;

    }


}
