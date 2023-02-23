package Tries;

public class Trie {

    private TrieNode root;

    public Trie()
    {
        root= new TrieNode('\0');
    }

    private void add( TrieNode root, String word )
    {
        if( word.length() == 0 )
        {
            root.isTerminating= true;
            return;
        }

        int childIndex= word.charAt(0) - 'a';
        TrieNode child= root.children[childIndex];

        if( child == null )
        {
            child= new TrieNode(word.charAt(0));
            root.children[childIndex]= child;
            root.childCount++;
        }

        add(child, word.substring(1));

    }

    public void add( String word )
    {
        // Adding for eg word= "NOTE"

        add(root, word);

    }

    private boolean search( TrieNode root, String word )
    {
        if( word.length() == 0 )
        {
            return root.isTerminating;
        }

        int childIndex= word.charAt(0) - 'a';
        TrieNode child= root.children[childIndex];

        if( child == null )
        {
            return false;
        }

        return search(child, word.substring(1));

    }

    public boolean search( String word )
    {
        return search(root, word);
    }

    private void remove( TrieNode root, String word )
    {
        if( word.length() == 0 )
        {
            root.isTerminating= false;
            return;
        }

        int childIndex= word.charAt(0) - 'a';
        TrieNode child= root.children[childIndex];

        if( child == null )
        {
            return;
        }

        remove(child, word.substring(1));

    }

    public void remove( String word )
    {
        remove(root, word);
    }

    private void removeBetter( TrieNode root, String word )
    {
        if( word.length() == 0 )
        {
            root.isTerminating= false;
            return;
        }

        int childIndex= word.charAt(0) - 'a';
        TrieNode child= root.children[childIndex];

        if( child == null )
        {
            return;
        }

        remove(child, word.substring(1));

        // Now after child work that is remove(child, word.substring(1));, Parent will decide whether to delete child or not. parent == root

        // Here parent will check two conditions 	There is AND between the conditions. Both of them must be true to remove the child node.
        // 1. We can remove child node if it is non- terminating AND
        //  2. Number of children is 0.


//		if( ! child.isTerminating )
//		{
//
//			int numChild= 0;
//
//			for( int i= 0; i< child.children.length; i++ )
//			{
//				if( child.children[i] != null )
//				{
//					numChild++;
//				}
//			}
//
//			if( numChild == 0 )
//			{
//				// Delete child
//
//				root.children[childIndex]= null;
//				child= null;		// Jo bhi uss node ka reference store kar raha tha wo sabhi cheeze null ko point karengi.
//									// so that Java mei garbage collector uss memory ko free karde.
//									// Java collector class frees the memory that is not used by anyone.
//
//			}


        if( ! child.isTerminating && child.childCount == 0 )
        {
            root.children[childIndex]= null;	// Setting everthing to null so that garbage class in java clears the unused memory
            child= null;
            root.childCount--;
        }

    }

    public void removeBetter( String word )
    {
        removeBetter(root, word);
    }

}

