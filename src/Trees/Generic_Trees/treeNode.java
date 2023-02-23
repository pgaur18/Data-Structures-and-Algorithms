package Trees.Generic_Trees;

import java.util.*;

public class treeNode< T >  {

    public T data;
    public ArrayList<treeNode<T>> children;


    public treeNode( T data )
    {
        this.data= data;
        children= new ArrayList<>();
    }

}
