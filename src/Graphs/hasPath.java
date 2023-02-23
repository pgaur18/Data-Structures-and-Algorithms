package Graphs;

import java.util.*;

public class hasPath {

    public static void hasPathBFSHelper( int edges[][], boolean visited[] , int SV )
    {
        Queue<Integer> q= new LinkedList<Integer>();
        q.add(SV);
        visited[SV]= true;

        while( ! q.isEmpty() )
        {
            int n= q.remove();

            for( int i= 0; i< edges.length; i++ )
            {
                if( edges[n][i] == 1 && ! visited[i] )
                {
                    q.add(i);
                    visited[i]= true;		// Queue mei add hote hi true ho jaayegaa
                }

            }

        }

    }

    public static boolean hasPathBFS( int edges[][], int SV , int EV )
    {
        boolean visited[]= new boolean[edges.length];

        hasPathBFSHelper(edges , visited , SV );

//	    if ( visited[EV] == true )
//	    {
//	    	return true;
//	    }
//	    else
//	    {
//	    	return false;
//	    }

        return visited[EV];		// Upar ki 5 line lo Single line mei kar diya

    }

    public static void hasPathDFSHelper(int edges[][] , boolean visited[] , int sv )
    {
        visited[sv] = true;

        for(int i = 0; i < edges.length ; i++)
        {
            if(edges[sv][i] == 1 && ! visited[i] )
            {
                hasPathDFSHelper(edges , visited , i);
            }

        }

    }

    public static boolean hasPathDFS( int edges[][], int SV , int EV )
    {
        boolean visited[]= new boolean[edges.length];
        hasPathDFSHelper(edges , visited , SV );

        if (visited[EV] == true)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public static boolean hasPathBFSRecursiveHelper( int edges[][], boolean visited[], int sv, int ev )
    {
        if( sv >= edges.length || ev >= edges.length )
        {
            return false;
        }

        if( edges[sv][ev] == 1 )
        {
            return true;
        }

        Queue<Integer> q= new LinkedList<>();

        q.add(sv);
        visited[sv]= true;

        while( ! q.isEmpty() )
        {
            int n= q.remove();

            for( int i= 0; i< edges.length; i++ )
            {
                if( edges[n][i] == 1 && ! visited[i] )
                {
                    if( i == ev )
                    {
                        return true;
                    }
                    else
                    {
                        q.add(i);
                        visited[i]= true;
                    }

                }

            }

        }

        return false;

    }

    public static boolean hasPathBFSRecursive( int edges[][], int SV, int EV )
    {
        boolean visited[]= new boolean[edges.length];

        return hasPathBFSRecursiveHelper(edges, visited, SV, EV);
    }

    public static boolean hasPathDFSRecursiveHelper( int edges[][], boolean visited[], int sv, int ev )
    {
        visited[sv]= true;

        if( sv >= edges.length || ev >= edges.length )
        {
            return false;
        }

        if( edges[sv][ev] == 1 )
        {
            return true;
        }

        for( int i = 0; i< edges.length; i++ )
        {
            if( edges[sv][i] == 1 && ! visited[i] )
            {
                if( i == ev )
                {
                    return true;
                }

                if( hasPathDFSRecursiveHelper(edges, visited, i, ev) )
                {
                    return true;
                }

            }

        }

        return false;

    }

    public static boolean hasPathDFSRecursive( int edges[][], int SV, int EV )
    {
        boolean visited[]= new boolean[edges.length];

        return hasPathDFSRecursiveHelper(edges, visited, SV, EV);
    }

    public static void main(String[] args) {


        Scanner sc= new Scanner(System.in);

        int n= sc.nextInt();
        int e= sc.nextInt();

        int edges[][]= new int[n][n];

        for( int i= 0; i<e; i++ )
        {
            int fv= sc.nextInt();	// fv= first vertex
            int sv= sc.nextInt();	// sv= second vertex;

            edges[fv][sv]= 1;		// since there is no direction therefore i,j and j,i both will be 1 ot true
            edges[sv][fv]= 1;

        }

        int SV= sc.nextInt();
        int EV= sc.nextInt();

        hasPathBFS(edges, SV, EV);

    }

}

