package Trees.BinaryTrees;

import java.util.*;

import java.util.ArrayDeque;
import java.util.Queue;

public class BSTSearch {

    static Scanner sc= new Scanner(System.in);

    public static bTreeNode<Integer> takeInputLevelWise( )
    {
        System.out.println("Enter root node : ");
        int rootData=sc.nextInt();

        if( rootData == -1 )
        {
            return null;
        }

        bTreeNode<Integer> root= new bTreeNode<>(rootData);

        Queue<bTreeNode<Integer> > q= new ArrayDeque<>();
        q.add(root);

        while( q.size() > 0 )
        {
            bTreeNode<Integer> node= q.remove();

//			System.out.println("How many children of "+root.data+" : ");    Binary tree has two children
//			int childCount=sc.nextInt();									Therefore loop will work twice.
//																			No need to ask no of children


            System.out.println("Enter left child of "+ node.data +" : ");
            int leftChild=sc.nextInt();

            if( leftChild != -1 )
            {
                bTreeNode<Integer> childNode= new bTreeNode<>(leftChild);
                q.add(childNode);
                node.left=childNode;
            }

            System.out.println("Enter right child of "+ node.data+" : ");
            int rightChild=sc.nextInt();


            if( rightChild != -1 )
            {
                bTreeNode<Integer> childNode=new bTreeNode<>(rightChild);
                q.add(childNode);
                node.right=childNode;

            }


        }


        return root;


    }

    public static void printLevelWiseBT( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            return;
        }

        Queue<bTreeNode<Integer>> q= new ArrayDeque<>();
        q.add(root);

        while( q.size() > 0 )
        {
            bTreeNode<Integer> node= q.remove();

            String str= node.data + ": ";

            if( node.left != null )
            {
                str+="L : "+ node.left.data + ", ";
                q.add(node.left);
            }

            if( node.right != null )
            {
                str+="R : "+ node.right.data;
                q.add(node.right);
            }

            System.out.println(str);

        }


    }

    public static bTreeNode<Integer> search( bTreeNode<Integer> root, int x )
    {
        if( root == null )
        {
            return null;
        }

        if( root.data == x )
        {
            return root;
        }

        if( x < root.data )
        {
            bTreeNode<Integer> node= search(root.left,x);
            return node;
        }

        else
        {
            bTreeNode<Integer> node= search(root.left,x);
            return node;
        }

    }

    public static void printRange( bTreeNode<Integer> root, int min, int max )
    {
        if( root == null )
        {
            return;
        }

        if( root.data > max )
        {
            printRange(root.left, min, max);
        }

        else if( root.data < min )
        {
            printRange(root.right, min, max);

        }
        else
        {
            printRange(root.left, min, max);
            System.out.print(root.data+" ");
            printRange(root.right, min, max);

        }


        // 40 20 60 10 30 50 70 -1 -1 -1 -1 -1 -1 -1 -1

    }

    public static int maxLeftValue( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            return Integer.MIN_VALUE;
        }

        int max= root.data;

        int cMaxLeft= maxLeftValue(root.left);
        int cMaxRight= maxLeftValue(root.right);

        return Math.max(max, Math.max(cMaxRight, cMaxLeft));

    }

    public static int minRightValue( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            return Integer.MAX_VALUE;
        }

        int min= root.data;

        int cMinLeft= minRightValue(root.left);
        int cMinRight= minRightValue(root.right);

        return Math.min(min, Math.min(cMinLeft, cMinRight));

    }

    public static boolean isBST1( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            return true;
        }

        int leftMax= maxLeftValue(root.left);
        int rightMin= minRightValue(root.right);

        if( root.data <=leftMax )
        {
            return false;
        }

        if( root.data > rightMin )
        {
            return false;
        }

        boolean isLeftBST= isBST1(root.left);
        boolean isRightBST= isBST1(root.right);

        if( isLeftBST && isRightBST )
        {
            return true;
        }

        else
        {
            return false;
        }

    }

    public static Pair< Boolean, Pair<Integer,Integer>> isBST2( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            Pair<Boolean, Pair<Integer,Integer>> output= new Pair<Boolean, Pair<Integer,Integer>>();
            output.first= true;
            output.second= new Pair<Integer, Integer>();

            output.second.first= Integer.MAX_VALUE;         	//	In Pair, we are using  first= min and second= max
            output.second.second= Integer.MIN_VALUE;

            return output;

        }

        Pair<Boolean, Pair<Integer, Integer>> lo= isBST2(root.left);
        Pair<Boolean, Pair<Integer, Integer>> ro= isBST2(root.right);


        int min= Math.min(root.data, Math.min(lo.second.first, ro.second.first));
        int max= Math.max(root.data, Math.max(lo.second.second, ro.second.second));

        boolean isBST= ( root.data > lo.second.second) && ( root.data <= ro.second.first )
                && ( lo.first )  && ( ro.first );

        Pair<Boolean, Pair<Integer,Integer>> output= new Pair<Boolean, Pair<Integer,Integer>>();
        output.first= isBST;

        output.second= new Pair<Integer, Integer>();

        output.second.first= min;         	//	In Pair, we are using  first= min and second= max
        output.second.second= max;

        return output;

    }

    public static boolean isBST3( bTreeNode<Integer> root , int min, int max )
    {
        if( root == null )
        {
            return true;
        }

        if( root.data < min || root.data > max)
        {
            return false;
        }

        boolean leftBool= isBST3(root.left, min, root.data-1);
        boolean rightBool= isBST3(root.right, root.data, max);

        if( leftBool && rightBool )
        {
            return true;
        }

        else
        {
            return false;
        }

    }

    public static bTreeNode<Integer> bstFromSortedArray( int arr[], int sI, int eI )
    {
        if( sI > eI )
        {
            return null;
        }

        int rootIndex= ( sI + eI )/2;  // rootIndex is same as mid of sorted array
        int rootData= arr[ rootIndex ];
        bTreeNode<Integer> root= new bTreeNode<>(rootData);

        int leftSI= sI;
        int leftEI= rootIndex-1;

        int rightSI= rootIndex+1;
        int rightEI= eI;

        root.left= bstFromSortedArray(arr, leftSI, leftEI);
        root.right= bstFromSortedArray(arr, rightSI, rightEI);

        return root;


    }

    public static LinkedList<Integer> LLFromBST( bTreeNode<Integer> root, LinkedList<Integer> ll1 )
    {
        if( root == null )
        {
            return null;
        }

        LLFromBST(root.left, ll1);

        ll1.add(root.data);

        LLFromBST(root.right, ll1);

        return ll1;

    }

    public static ArrayList<Integer> rootToNodePathBT( bTreeNode<Integer> root, int x )
    {
        if( root == null )
        {
            return null;
        }

        if( root.data == x )
        {
            ArrayList<Integer> output= new ArrayList<>();
            output.add(root.data);
            return output;
        }

        ArrayList<Integer> lo= rootToNodePathBT(root.left, x);
        ArrayList<Integer> ro= rootToNodePathBT(root.right, x);

        if( lo != null )
        {
            lo.add(root.data);
            return lo;
        }

        if( ro != null )
        {
            ro.add(root.data);
            return ro;
        }

        else
        {
            return null;
        }

    }

    public static ArrayList<Integer> rootToNodePathBST( bTreeNode<Integer> root, int x )
    {
        if( root == null )
        {
            return null;
        }

        if( root.data == x )
        {
            ArrayList<Integer> output= new ArrayList<>();
            output.add(root.data);
            return output;
        }

        if( root.data > x )
        {
            ArrayList<Integer> lo= rootToNodePathBST( root.left, x );

            if( lo != null )
            {
                lo.add(root.data);
                return lo;
            }

            return null;

        }
        else if( root.data < x )
        {
            ArrayList<Integer> ro= rootToNodePathBST( root.right, x );

            if( ro != null )
            {
                ro.add(root.data);
                return ro;
            }

            return null;

        }

        else
        {
            return null;
        }

    }

    public static void main(String[] args) {


        bTreeNode<Integer> root= takeInputLevelWise();
//		boolean bool= isBST1(root);
//		System.out.println(bool);
//		printRange(root, 20, 50);


//		boolean bool= isBST3(root,-100, 100);
//		System.out.println(bool);


//		int arr[]= {1,2,3,4,5,6,7};
//
//		bTreeNode<Integer> root= bstFromSortedArray(arr, 0, arr.length-1 );
//		printLevelWiseBT(root);


//		ArrayList<Integer> AR= rootToNodePathBT(root,45);
//
//		if( AR == null )
//		{
//			System.out.println("NULL");
//		}
//		else
//		{
//			System.out.println(AR);
//		}



//		printRange(root, 20, 50);

//		LinkedList<Integer> ll1= new LinkedList<>();
//		ll1= LLFromBST( root, ll1 );
//		System.out.println(ll1);

        ArrayList<Integer> AR= rootToNodePathBST(root, 3);

        if( AR == null )
        {
            System.out.println("NULL");
        }
        else
        {
            System.out.println(AR);
        }


//		BinarySearchTree bst= new BinarySearchTree();
//
//		bst.insertData(10);
//		bst.insertData(20);
//		bst.insertData(5);
//		bst.insertData(15);
//		bst.insertData(3);
//		bst.insertData(7);
//		bst.printTree();
//
//		bst.deletedata(10);
//		System.out.println();
//		bst.printTree();


    }

}
