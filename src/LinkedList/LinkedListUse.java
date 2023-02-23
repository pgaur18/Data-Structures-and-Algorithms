package LinkedList;

import java.util.*;

public class LinkedListUse {

    static Scanner sc= new Scanner(System.in);

    public static void Print( Node<Integer> head )
    {
        Node<Integer> temp= head;

        while( temp != null )
        {
            System.out.print(temp.data+ ", ");
            temp= temp.next;
        }

        System.out.println();

    }

    public static Node<Integer> takeInput()
    {
        Node<Integer> head= null;
        System.out.println("Enter next data : ");
        int input= sc.nextInt();

        while( input != -1 )
        {
            Node<Integer> newNode= new Node<>(input);

            if( head == null )
            {
                head= newNode;
            }
            else
            {								// We don't have or we are not using tail here.
                Node<Integer> temp= head;

                while( temp.next != null )
                {
                    temp= temp.next;
                }

                temp.next= newNode;

            }

            System.out.println("Enter next data : ");
            input= sc.nextInt();

        }

        return head;

    }

    public static Node<Integer> takeInputBetter()
    {
        Node<Integer> head= null;
        Node<Integer> tail= null;

        System.out.println("Enter next data : ");
        int input= sc.nextInt();

        while( input != -1 )
        {
            Node<Integer> newNode= new Node<>(input);

            if( head == null )
            {
                head= tail= newNode;
            }
            else
            {
                tail.next= newNode;
                tail= newNode;		// tail= tail.next;
            }

            System.out.println("Enter next data : ");
            input= sc.nextInt();

        }

        return head;

    }

    public static Node<Integer> insert( Node<Integer> head, int pos, int data )
    {

        Node<Integer> newNode= new Node<>(data);

        if( pos == 0 )
        {
            newNode.next= head;
            return newNode;
        }

        Node<Integer> temp= head;

        for( int i=0; i< pos-1; i++ )  		// The loop will break the moment we are at pos-1.
        {
            temp= temp.next;
        }

        newNode.next= temp.next;
        temp.next= newNode;

        return head;

    }

    public static Node<Integer> reverseRecursive( Node<Integer> head )
    {
        if( head == null || head.next == null )
        {
            return head;
        }

        Node<Integer> finalHead= reverseRecursive(head.next);

        Node<Integer> temp= finalHead;

        while( temp.next != null )
        {
            temp= temp.next;
        }

        temp.next= head;
        head.next= null;

        return finalHead;

    }

    public static DoubleNode reverseRecursiveBetter( Node<Integer> head )
    {
        if( head == null || head.next == null )
        {
            DoubleNode ans= new DoubleNode();
            ans.head= head;
            ans.tail= head;
            return ans;
        }

        DoubleNode smallAns= reverseRecursiveBetter(head.next);

        smallAns.tail.next= head;
        head.next= null;

        DoubleNode ans= new DoubleNode();
        ans.head= smallAns.head;
        ans.tail= head;

        return ans;


    }

    public static Node<Integer> reverseRecursiveBest( Node<Integer> head )
    {
        if( head == null || head.next == null )
        {
            return head;
        }

        Node<Integer> reverseTail= head.next;
        Node<Integer> smallHead= reverseRecursiveBest(head.next);
        reverseTail.next= head;
        head.next= null;

        return smallHead;


    }

    public static Node<Integer> insertRecursively( Node<Integer> head, int pos, int data )
    {
        if( pos == 0 || head == null )      // if pos > length and we should add at the last index then add head == null condition with
        {
            Node<Integer> newNode= new Node<>(data);
            newNode.next= head;
            return newNode;
        }

        Node<Integer> smallAns= insertRecursively(head.next, pos-1, data);
        head.next= smallAns;

//		if( head == null )     If pos > length and we don't have to ( according to the question) then remove   head == null  from above base case and add this condition after base case
//		{
//			return head;
//		}

//		The above two lines can be replaced by 	    head.next= insertRecursively(head.next, pos-1, data);

        return head;	// overall head of the list is returned

    }

    public static Node<Integer> deleteRecursively( Node<Integer> head, int pos )
    {
        if( pos == 0 )
        {
            return head.next;
        }

        if( head == null )   // If pos > length
        {
            return head;
        }

        head.next= deleteRecursively(head.next, pos-1);

        return head;

    }

    public static void main(String[] args) {

//		Node<Integer> node1= new Node<>(10);
//		Node<Integer> node2= new Node<>(20);
//		Node<Integer> node3= new Node<>(30);
//
//		node1.next= node2;
//		node2.next= node3;
//
//		Print(node1);
//		Print(node1);

        Node<Integer> head= takeInput();
        Print(head);

//		head= insert(head, 3, 80);
//		Print(head);

//		Node<Integer> newHead= reverseRecursive(head);
//
//		Print(newHead);
//
//		DoubleNode d= reverseRecursiveBetter(head);
//		Print(d.head);

//		head= reverseRecursiveBest(head);
//		Print(head);

        head= insertRecursively(head, 0, 10);
        Print(head);

        head= deleteRecursively(head, 3);
        Print(head);

    }

}
