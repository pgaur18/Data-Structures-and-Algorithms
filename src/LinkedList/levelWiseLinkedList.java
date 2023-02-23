package LinkedList;

import java.util.*;


public class levelWiseLinkedList {

    static Scanner sc= new Scanner(System.in);

    public static BTreeNode takeInputLevelWise( )
    {
        System.out.println("Enter root node : ");
        int rootData=sc.nextInt();

        if( rootData == -1 )
        {
            return null;
        }

        BTreeNode root= new BTreeNode(rootData);

        Queue<BTreeNode> q= new ArrayDeque<>();
        q.add(root);

        while( q.size() > 0 )
        {
            BTreeNode node= q.remove();

//			System.out.println("How many children of "+root.data+" : ");    Binary tree has two children
//			int childCount=sc.nextInt();									Therefore loop will work twice.
//																			No need to ask no of children


            System.out.println("Enter left child of "+ node.data +" : ");
            int leftChild=sc.nextInt();

            if( leftChild != -1 )
            {
                BTreeNode childNode= new BTreeNode(leftChild);
                q.add(childNode);
                node.left=childNode;
            }

            System.out.println("Enter right child of "+ node.data+" : ");
            int rightChild=sc.nextInt();


            if( rightChild != -1 )
            {
                BTreeNode childNode=new BTreeNode(rightChild);
                q.add(childNode);
                node.right=childNode;

            }


        }


        return root;


    }

    public static void main(String[] args) {

        BTreeNode root = takeInputLevelWise();
        ArrayList<LinkedListNode<Integer>> ans = constructLinkedListForEachLevel(root);
        System.out.println(ans.toString());

    }

    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BTreeNode root) {

        // Write your code here

        if( root == null )
        {
            return null;
        }

        ArrayList<LinkedListNode<Integer>> ar= new ArrayList<>();
        LinkedListNode<Integer> head= null;
        LinkedListNode<Integer> tail= null;

        Queue<BTreeNode> q= new ArrayDeque<>();
        BTreeNode distinct = new BTreeNode(Integer.MIN_VALUE);
        q.add(root);
        q.add(distinct);


        while( q.size() > 0 )
        {
            BTreeNode node= q.remove();


            if( node.data != Integer.MIN_VALUE )
            {
                System.out.print(node.data+" ");

                LinkedListNode<Integer> newNode= new LinkedListNode<>(node.data);
                newNode.next=null;

                if( head == null )
                {
                    head= newNode;
                    tail= newNode;
                }
                else
                {
                    tail.next= newNode;
                    tail= tail.next;
                }

                if( node.left != null )
                {
                    q.add(node.left);
                }


                if( node.right != null )
                {
                    q.add(node.right);
                }

            }

            else
            {

                if( q.size() != 0 )
                {
                    q.add(distinct);
                    ar.add(head);
                    head= null;
                    tail= null;
                }
                else
                {
                    ar.add(head);

                }

            }

        }

        return ar;

    }

}
class BTreeNode {

    public int data;
    public BTreeNode left;
    public BTreeNode right;

    public BTreeNode( int data )
    {
        this.data=data;
        this.left= null;
        this.right= null;
    }

}
