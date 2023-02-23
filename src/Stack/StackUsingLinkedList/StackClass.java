package Stack.StackUsingLinkedList;

import java.util.*;

public class StackClass<T> {

    static Scanner sc= new Scanner(System.in);

    private stackNode<Integer> head;
    private stackNode<Integer> tail;
    int size;


    public void takeInput()
    {
        System.out.println("Enter data : ");
        int n = sc.nextInt();

        while( n != -1 )
        {
            Push(n);

            System.out.println("Enter next data : ");
            n= sc.nextInt();

        }


    }

    public void Push( int value )
    {
        stackNode<Integer> node= new stackNode<>(value);
        size++;

        if( head == null )
        {
            head= tail= node;
        }

        else
        {
            tail.next= node;
            tail= tail.next;
        }

    }

    public void Pop()      // this should be be int instead of void because it will return deleted int or char or whatever
    {
        System.out.println();

        if( head == null )
        {
            System.out.println("Stack is empty");
            return;
        }

        if( head == tail )
        {
            System.out.println("Element Popped is : "+ head.data);
            size--;
            head= tail= null;
        }
        else
        {
            System.out.println("Element Popped is :"+ tail.data);
            size--;
            stackNode<Integer> temp= head;

            while( temp.next.next != null )
            {
                temp= temp.next;
            }

            temp.next= null;
            tail= temp;

        }

    }

    public void Peek()
    {
        System.out.println();

        if( head == null )
        {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.println("Peek -> "+ tail.data);

    }

    public void Size()
    {
        System.out.println("Size ->"+ size);
    }

}
