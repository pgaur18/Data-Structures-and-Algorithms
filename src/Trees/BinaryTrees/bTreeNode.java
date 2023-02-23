package Trees.BinaryTrees;

public class bTreeNode < T > {

    public T data;
    public bTreeNode<T> left;
    public bTreeNode<T> right;

    public bTreeNode( T data )
    {
        this.data=data;
        this.left= null;
        this.right= null;
    }

}