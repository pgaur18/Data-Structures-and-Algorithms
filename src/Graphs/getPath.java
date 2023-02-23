package Graphs;

import java.util.*;

public class getPath {

    public static ArrayList<Integer> getPathDFSHelper( int edges[][], boolean visited[], int sv, int ev )
    {
        visited[sv]= true;

        if( sv == ev )
        {
            ArrayList<Integer> ans= new ArrayList<>();
            ans.add(ev);
            return ans;
        }

        for( int i= 0; i< edges.length; i++ )
        {
            if( edges[sv][i] == 1 && ! visited[i] )
            {
                ArrayList<Integer> ans= getPathDFSHelper(edges, visited, i, ev);

                if( ans.size() != 0 )
                {
                    ans.add(sv);
                    return ans;
                }

            }

        }

        ArrayList<Integer> ans= new ArrayList<>();

        return ans;

    }

    public static ArrayList<Integer> getPathDFS( int edges[][], int SV, int EV )
    {
        boolean visited[]= new boolean[edges.length];

        return getPathDFSHelper(edges, visited, SV, EV );

    }

    public static ArrayList<Integer> getPathBFSHelper( int edges[][], boolean visited[], int sv, int ev )
    {
        if( sv >= edges.length || ev >= edges.length )
        {
            ArrayList<Integer> ans= new ArrayList<>();

            return ans;
        }

        Queue<Integer> q= new LinkedList<>();
        q.add(sv);
        visited[sv]= true;

        ArrayList<Integer> ans= new ArrayList<>();

        while( ! q.isEmpty() )
        {
            int n= q.remove();

            if( n == ev )
            {
                ans.add(n);
                return ans;
            }

            else
            {
                ans.add(n);

                for( int i= 0; i< edges.length; i++ )
                {
                    if( edges[n][i] == 1 && ! visited[n] )
                    {
                        q.add(i);
                        visited[i]= true;
                    }

                }

            }

        }

        ArrayList<Integer> notPath= new ArrayList<>();

        return notPath;

    }

    public static ArrayList<Integer> getPathBFS( int edges[][], int SV, int EV )
    {
        boolean visited[]= new boolean[edges.length];

        return getPathDFSHelper(edges, visited, SV, EV );

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



    }

}
