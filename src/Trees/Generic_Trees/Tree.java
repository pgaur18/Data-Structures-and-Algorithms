package Trees.Generic_Trees;
import java.util.*;

public class Tree {

    static class Pair2<T>
    {
        T data;
        T smax;
//		treeNode<Integer> node;
    }

    public static Pair2<Integer> Helper( treeNode<Integer> root )
    {
        if( root == null )
        {
            Pair2<Integer> output= new Pair2<>();
            output.data= Integer.MIN_VALUE;
            output.smax= Integer.MIN_VALUE;
//			output.node= root;
        }

        Pair2<Integer> ans= new Pair2<>();
        ans.data= root.data;
        ans.smax= Integer.MIN_VALUE;
//		ans.node= root;

        for( treeNode<Integer> child : root.children )
        {
            Pair2<Integer> childAns= Helper(child);

            if( childAns.data > ans.data )
            {
                ans.smax= ans.data;
                ans.data= childAns.data;

            }
            else if( childAns.data < ans.data && child.data > ans.smax )
            {
                ans.smax= child.data;
            }
        }

        return ans;
    }

    public static int printSecondLargest( treeNode<Integer> root )
    {
        return Helper(root).smax;
    }

    static Scanner sc= new Scanner(System.in);

    public static treeNode<Integer> takeInput()
    {
//		Scanner sc= new Scanner(System.in);    Scanner issue
        System.out.println("Enter next node : ");
        int n=sc.nextInt();

        treeNode<Integer> root= new treeNode<>(n);
        System.out.println("Enter no of child for : "+n );
        int childCount= sc.nextInt();

        for( int i=0; i<childCount; i++ )
        {
            treeNode<Integer> child= takeInput();
            root.children.add(child);
        }

        return root;

    }

    public static void print( treeNode<Integer> root )
    {
        String str = root.data+":";

        for( treeNode<Integer> child: root.children )
        {
            str+= child.data + ",";

        }

        System.out.println(str);

        for( treeNode<Integer> child : root.children )
        {
            print(child);
        }

    }

    public static treeNode<Integer> takeInputLevelWise( )
    {
        System.out.println("Enter root data :");
        int rootData=sc.nextInt();

        treeNode<Integer> root= new treeNode<>(rootData);
        Queue<treeNode<Integer>> q= new LinkedList<>();

        q.add(root);

        while( q.size() > 0 )
        {

            treeNode<Integer> node = q.remove();		// q.poll()

            System.out.println("enter no of children of "+ node.data+" :");
            int childCount= sc.nextInt();

            for( int i=0; i<childCount; i++ )
            {
                System.out.println("Enter "+ ( i+1 )+ " th "+ " child of "+ node.data);

                int child= sc.nextInt();
                treeNode<Integer> childNode= new treeNode<>(child);

                node.children.add(childNode); // node connected to parent node
                q.add(childNode);    // node added to the queue

            }

        }

        return root;

    }

    public static void printLevelWise( treeNode<Integer> root)
    {
        Queue< treeNode<Integer>> q= new ArrayDeque<>();
        q.add(root);

        while( q.size() > 0 )
        {

            treeNode<Integer> node = q.remove();
            System.out.print(node.data+ " : ");

// 			Same as below for loop
//			for( treeNode<Integer> child : node.children )
//			{
//				System.out.print(child.data+", ");
//				q.add(child);
//
//			}

            for( int i=0; i<node.children.size(); i++ )
            {

                System.out.print(node.children.get(i).data+ ", ");
                q.add(node.children.get(i));

            }

            System.out.println();


        }


    }

    public static int noOfNodes( treeNode<Integer> root )
    {

        int s=0;

        for( treeNode<Integer> child : root.children )
        {
            int cs= noOfNodes(child);
            s+=cs;
        }

        return s+1;

    }

    public static int size(treeNode<Integer> root )
    {
        int count=1;

        for( treeNode<Integer> child : root.children)
        {
            count+= size(child);
        }

        return count;



    }

    public static int sumOfNodes( treeNode<Integer> root )
    {
        if( root == null )
        {
            return 0;
        }

        int sum= root.data;
        for( treeNode<Integer> child : root.children )
        {
            int cs= sumOfNodes(child);
            sum+=cs;
        }

        return sum;

    }

    public static int largest( treeNode<Integer> root )
    {
        int max=root.data;

        for( treeNode<Integer> child : root.children )
        {
            int cmax= largest(child);
            max= Math.max(max, cmax);
        }

        return max;

    }

    public static int greaterThan( treeNode<Integer> root, int x)
    {
        int count=0;

        if( root.data > x )
        {
            count++;
        }

        for( treeNode<Integer> child : root.children )
        {
            int childCount= greaterThan(child,x);
            count+=childCount;
        }

        return count;

    }

    public static int height( treeNode<Integer> root )
    {
        int h=0;

        for( treeNode<Integer> child : root.children )
        {
            int ch= height(child);	// ch= childHeight
            h= Math.max(h, ch);

        }

        return h+1;


    }

    public static int depth( treeNode<Integer> root )
    {
        int d=0;

        for( treeNode<Integer> child : root.children )
        {
            int cd= depth(child);
            d=Math.max(cd, d);

        }

        return d+1;

    }

    public static void printAllAtK( treeNode<Integer> root , int k )
    {
        if( k < 0 )
        {
            return;
        }

        if( k == 0 )
        {
            System.out.print(root.data+ ", ");
            return;
        }

        for( treeNode<Integer> child : root.children )
        {
            printAllAtK(child, k-1 );
        }

    }

    public static int countLeafNodes( treeNode<Integer> root )
    {
        int ln= 0;       // ln=leafNode

        if( root.children.size() == 0 )
        {
            return 1;
        }

        for( treeNode<Integer> child : root.children )
        {
            int cln= countLeafNodes(child);      // cln= childLeafNode
            ln+=cln;

        }

        return ln;

    }

    public static void printPostOrder( treeNode<Integer> root )
    {

        for( treeNode<Integer> child : root.children )
        {
            printPostOrder(child);
        }

        System.out.print(root.data+", ");

    }

    public static void printPreOrder( treeNode<Integer> root )
    {
        System.out.print(root.data+", ");

        for( treeNode<Integer> child : root.children )
        {
            printPreOrder(child);
        }



    }

    public static int Height( treeNode<Integer> root )
    {
        int height=0;

        for( treeNode<Integer> child : root.children )
        {
            int ch= Height(child);
            height= Math.max(ch, height);
        }

        return height+1;

    }

    public static boolean removeLeafHelper( treeNode<Integer> root )
    {
        if( root == null )
        {
            return false;
        }

        if( root.children.size() == 0 )
        {
            return false;
        }

        for( treeNode<Integer> child : root.children )
        {
            boolean ans= removeLeafHelper(child);

            if( ans )
            {
                root.children.remove(child);
            }

        }

        return false;

    }

    public static void removeLeafNodes( treeNode<Integer> root )
    {
        if( root == null )
        {
            return;
        }

        removeLeafHelper(root);

    }

    public static void main(String[] args) {

//		treeNode<Integer> root= takeInput();
//		print(root);

        treeNode<Integer> root= takeInputLevelWise();
        printLevelWise(root);
        removeLeafNodes(root);

        System.out.println("After removal of leaf nodes ");
        printLevelWise(root);

//		int h=Height(root);
//
//		System.out.println(h);
//
//		printLevelWise(root);

//		int totalsize=size(root);				//noOfNodes(root);
//
//		System.out.println("Size of the node is : "+totalsize);


//		int sum= sumOfNodes(root);					// Sum Of Nodes
//		System.out.println("sum of nodes : "+sum);

//		int max= largest(root);
//		System.out.println("Max is : "+max);

//		int z= greaterThan(root,20);
//		System.out.println("Greater No: "+z);

//		int ht= height(root);
//		System.out.println("Height of the tree : "+ht);

//		int Depth= depth(root);
//		System.out.println("Depth : "+  Depth);

//		printAllAtK(root, 2 );

//		int leafNodes=countLeafNodes(root);
//		System.out.println("Total leaf nodes : "+leafNodes);


//		printPostOrder(root);
//		printPreOrder(root);

//		int n= printSecondLargest( root );
//		System.out.println("Second largest : "+n );


//		treeNode<Integer> root= new treeNode<>(4);
//		treeNode<Integer> node1= new treeNode<>(2);
//		treeNode<Integer> node2= new treeNode<>(3);
//		treeNode<Integer> node3= new treeNode<>(5);
//		treeNode<Integer> node4= new treeNode<>(6);
//
//
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		node2.children.add(node4);
//
//		System.out.println(root);

    }

}
