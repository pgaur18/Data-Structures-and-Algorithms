package Trees.BinaryTrees;

public class BinarySearchTree {

    private static bTreeNode<Integer> root;

    public void printTree()
    {
        printBSTHelper(root);
    }

    private void printBSTHelper( bTreeNode<Integer> root )
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

        printBSTHelper(root.left);
        printBSTHelper(root.right);

    }

    private boolean hasDataHelper( bTreeNode<Integer> root, int data  )
    {
        if( root == null )
        {
            return false;
        }

        if( root.data == data )
        {
            return true;
        }

        else if( data >= root.data )
        {
            return hasDataHelper(root.right, data);
        }
        else
        {
            return hasDataHelper(root.left, data);
        }


    }

    public boolean hasData( int data )
    {
        return hasDataHelper(root, data);
    }

    public bTreeNode<Integer> insertDataHelper( bTreeNode<Integer> root, int data )
    {
        if( root == null )
        {
            bTreeNode<Integer> newNode= new bTreeNode<>(data);
            root= newNode;
            return root;
        }

        if( data > root.data )
        {
            root.right= insertDataHelper(root.right, data);
        }

        else
        {
            root.left= insertDataHelper(root.left, data);
        }

        return root;

    }

    public void insertData( int data )
    {
        root=insertDataHelper(root, data );
    }

    private bTreeNode<Integer> deleteDataHelper( bTreeNode<Integer> root, int data )
    {
        if( root == null )
        {
            return null;
        }

        if( data > root.data )
        {
            root.right= deleteDataHelper(root.right, data);
            return root;
        }

        else if( data < root.data )
        {
            root.left= deleteDataHelper(root.left, data);
            return root;
        }

        else
        {
            if( root.left == null && root.right == null )
            {
                return null;

            }
            else if( root.left == null )
            {
                return root.right;

            }
            else if( root.right == null )
            {
                return root.left;
            }
            else if ( root.left == null )
            {
                return root.left;
            }
            else
            {
                bTreeNode<Integer> minNode= root.right;

                while( minNode.left != null )
                {
                    minNode= minNode.left;
                }

                root.data= minNode.data;

                root.right= deleteDataHelper( root.right, minNode.data);

                return root;

            }

        }

    }

    public void deletedata( int data )
    {
        root= deleteDataHelper(root, data);

    }

}

