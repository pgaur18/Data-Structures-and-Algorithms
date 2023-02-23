package Trees.BinaryTrees;
import java.util.*;

public class bTree {

    static Scanner sc= new Scanner(System.in);

    public static bTreeNode<Integer> takeInput()
    {
        System.out.println("Enter next node : ");
        int rootData= sc.nextInt();

        if( rootData == -1 )
        {
            return null;
        }

        bTreeNode<Integer> root= new bTreeNode<>(rootData);

        root.left=takeInput();
        root.right=takeInput();
        return root;
    }

    public static void print( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            return;
        }

        String toBePrinted = root.data + ": ";

        if( root.left != null )
        {
            toBePrinted+= "L : "+ root.left.data + ", ";

        }

        if( root.right != null )
        {
            toBePrinted+= "R : "+ root.right.data;

        }

        System.out.println(toBePrinted);

        print(root.left);
        print(root.right);

    }

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

    public static int countNodes( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            return 0;
        }

        int treeNodes=1;

        int leftNodes= countNodes(root.left);
        int rightNodes= countNodes(root.right);

        return leftNodes+ rightNodes + treeNodes;


    }

    public static boolean isPresent( bTreeNode<Integer> root, int x )
    {
        if( root == null )
        {
            return false;
        }

        if( root.data == x )
        {
            return true;
        }

        boolean left= isPresent(root.left, x );
        boolean right= isPresent(root.right, x);

        if( left || right )
        {
            return true;
        }
        else
        {
            return false;
        }


    }

    public static int height( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            return 0;
        }

        int ht=1;				// we are declaring ht=1 and then changing its value by max.
        // Then return ht+1. We are adding one becuase when we changed
        // ht by max that initially 1 value was lost.There it is added
        // before return ht;

        int lch= height(root.left);
        int rch= height(root.right);

        ht=Math.max(lch, rch);  // Better solution in treesPractice

        return ht+1;

    }

    public static void mirrorBTree( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            return;
        }

        bTreeNode<Integer> temp;

        temp=root.left;
        root.left= root.right;
        root.right= temp;

        mirrorBTree(root.left);
        mirrorBTree(root.right);

    }

    public static int diameterOfBTree( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            return 0;
        }

        int option1= height(root.left) + height(root.right);

        int option2= diameterOfBTree(root.left);

        int option3= diameterOfBTree(root.right);

        return Math.max(option1, Math.max(option2, option3));

    }

    public static Pair<Integer,Integer> betterDiameter( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            Pair<Integer,Integer> output= new Pair<>();
            output.first=0;
            output.second=0;
            return output;
        }

        Pair<Integer,Integer> lo= betterDiameter(root.left);
        Pair<Integer,Integer> ro= betterDiameter(root.right);

        int height= 1 + Math.max(lo.first, ro.first);

        int option1= lo.first + ro.first;
        int option2= lo.second;
        int option3= ro.second;

        int diameter= Math.max(option1, Math.max(option2, option3));

        Pair<Integer,Integer> output= new Pair<>();
        output.first=height;
        output.second= diameter;

        return output;

    }

    public static void preOrderTraversal( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            return;
        }

        System.out.print(root.data+", ");

        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    public static void postOrderTraversal( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);

        System.out.print(root.data+", ");


    }

    public static void inOrderTraversal( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            return;
        }

        inOrderTraversal(root.left);

        System.out.print(root.data+", ");

        inOrderTraversal(root.right);

    }

    public static bTreeNode<Integer> buildTreeHelper1(int in[], int pre[], int inS, int inE, int preS, int preE )
    {
        if( inS > inE )        // Base case
        {
            return null;	   // length of the array is zero  then inS=0
            //  and inE=length-1 that is -1.
        }

        int rootData= pre[preS]; //  not pre[0]. We have to work in our range.

        bTreeNode<Integer> root= new bTreeNode<>(rootData);

        int rootIndex=-1;

        for( int i= inS; i<= inE; i++ )
        {
            if( in[i] == rootData )
            {
                rootIndex=i;
                break;
            }

        }

        if( rootIndex == -1 )
        {
            return null;		// element that is present in preOrder array is not present in
            // the inOrder. Therefore the input is wrong and we will return null.
        }

        int leftInS= inS;
        int leftInE= rootIndex - 1;
        int leftPreS= preS + 1;
        int leftPreE= leftInE - leftInS + leftPreS;

        int rightInS= rootIndex + 1;
        int rightInE= inE;
        int rightPreS= leftPreE + 1;
        int rightPreE= preE;


        root.left= buildTreeHelper1( in, pre, leftInS, leftInE, leftPreS, leftPreE);
        root.right= buildTreeHelper1( in, pre, rightInS, rightInE, rightPreS, rightPreE);

        return root;


    }

    public static bTreeNode<Integer> buildTree1( int in[], int pre[] )
    {
        return buildTreeHelper1( in, pre, 0, in.length-1, 0, pre.length-1 );

    }

    public static bTreeNode<Integer> buildTreeHelper2(int in[], int post[], int inS, int inE, int postS, int postE)
    {
        if( inS > inE )
        {
            return null;
        }

        int rootData= post[postE];
        bTreeNode<Integer> root= new bTreeNode<>(rootData);

        int rootIndex=-1;

        for( int i=inS; i<= inE; i++ )
        {
            if( rootData == in[i] )
            {
                rootIndex=i;
                break;
            }

        }

        if( rootIndex == -1 )
        {
            return null;
        }

        int leftInS= inS;
        int leftInE= rootIndex-1;
        int leftPostS= postS;
        int leftPostE= leftInE - leftInS + leftPostS;

        int rightInS= rootIndex+1;
        int rightInE= inE;
        int rightPostS= leftPostE+1;
        int rightPostE= postE-1;

        root.left= buildTreeHelper2(in, post, leftInS, leftInE, leftPostS, leftPostE);
        root.right= buildTreeHelper2(in, post, rightInS, rightInE, rightPostS, rightPostE);

        return root;

    }

    public static bTreeNode<Integer> buildTree2(int in[], int post[] )
    {
        return buildTreeHelper2(in, post, 0, in.length-1, 0, post.length-1 );
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

    public static void printLeftView1( bTreeNode<Integer> root )
    {
        if( root == null )
        {
            return;
        }

        Queue<bTreeNode<Integer>> q= new LinkedList<>();
        bTreeNode<Integer> distinct= new bTreeNode<>(Integer.MIN_VALUE);
//		bTreeNode<Integer> waste= new bTreeNode<>(Integer.MAX_VALUE);


        q.add(root);
        q.add(distinct);

        while( q.size() > 0 )
        {
            bTreeNode<Integer> node= q.remove();

            if( node.data != Integer.MIN_VALUE )
            {
                if( node.left != null )
                {
                    q.add(node.left);
                }

                if( node.right != null )
                {
                    q.add(node.right);
                }

                System.out.print(node.data+" ");

                boolean bool= true;

                while( bool )
                {
                    node= q.remove();

                    if( node.data != Integer.MIN_VALUE )
                    {
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
                        bool= false;
                    }


                }

            }

            else
            {
                if( q.size() != 0 )
                {
                    q.add(distinct);
                }

            }

        }

    }

    static int maxLevel= 0;

    public static void printLeftView2( bTreeNode<Integer> root )
    {
        printLeftView2Helper( root, 1);
    }

    public static void printLeftView2Helper( bTreeNode<Integer> root, int level )
    {
        if( root == null )
        {
            return;
        }

        if( maxLevel < level )
        {
            System.out.print(root.data+" ");
            maxLevel= level;
        }

        printLeftView2Helper(root.left, level+1);
        printLeftView2Helper(root.right, level+1);

    }

    public static void printRightView( bTreeNode<Integer> root )
    {
        printRightViewHelper( root, 1);
    }

    public static void printRightViewHelper( bTreeNode<Integer> root, int level)
    {
        if( root == null )
        {
            return;
        }

        if( maxLevel < level )
        {
            System.out.print(root.data+" ");
            maxLevel= level;
        }

        printRightViewHelper(root.right,level+1);
        printRightViewHelper(root.left, level+1);

    }

    public static ArrayList<Integer> reverseLevelOrder( bTreeNode<Integer> root )
    {
        Queue<bTreeNode<Integer>> q= new LinkedList<>();
        Stack<Integer> st= new Stack<>();
        q.add(root);

        while( q.size() > 0 )
        {
            bTreeNode<Integer> node= q.remove();
            st.push(node.data);

            if( node.right != null )
            {
                q.add(node.right);
            }

            if( node.left != null )
            {
                q.add(node.left);
            }

        }

        ArrayList<Integer> ar= new ArrayList<>();

        while( st.size() != 0 )
        {
            ar.add(st.pop());
        }

        return ar;

    }

    public static void main(String[] args) {


        bTreeNode<Integer> root= takeInputLevelWise();
//		printLevelWiseBT(root);

        ArrayList<Integer> output= reverseLevelOrder(root);

        for( int i : output )
        {
            System.out.print(i+ ", ");
        }


//		printLeftView1(root);
//		printLeftView2(root);
//		printRightView(root);

//		int pre[]= {1,2,4,5,3,6,7};
//		int post[]= {4,5,2,6,7,3,1};
//		int in[]= {4,2,5,1,6,3,7};

//		bTreeNode<Integer> node= buildTree1(in,pre);
//		print(node);
//
//		System.out.println();
//
//		node= buildTree2(in, post);
//		print(node);
//
//		bTreeNode<Integer> node= search(root,4);
//		System.out.println(node.data);



//		bTreeNode<Integer> node = buildTree1(in, pre);
//		print(node);


//		int count= countNodes(root);
//		System.out.println("Total nodes : "+count);

//		boolean bool= isPresent(root, 4);
//		System.out.println("Result : "+bool);

//		printLevelWiseBT(root);

//
//		int height=height(root);
//		System.out.println("Height of the tree: "+height);

//		printLevelWiseBT(root);
//		mirrorBTree(root);
//		printLevelWiseBT(root);


//		Pair<Integer,Integer> p1= betterDiameter(root);
//		System.out.println("Height is : "+p1.first);
//		System.out.println("Diameter is : "+p1.second);

//		System.out.print("Pre Order Traversal : ");
//		preOrderTraversal(root);

//		System.out.print("Post Order Traversal : ");
//		postOrderTraversal(root);

//		System.out.print("In Order Traversal : ");
//		inOrderTraversal(root);


//		bTreeNode<Integer> root= new bTreeNode<>(1);
//		bTreeNode<Integer> node1= new bTreeNode<>(2);
//		root.left=node1;
//		bTreeNode<Integer> node2= new bTreeNode<>(3);
//		root.right=node2;



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
