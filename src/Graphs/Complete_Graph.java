package Graphs;

import java.util.*;

public class Complete_Graph {

    public static void printToggle( int edges[][], int sv )	// sv= start vertex
    {
        System.out.println(sv);

        int n= edges.length;

        for( int i= 0; i< n; i++ )
        {
            if( edges[sv][i] == 1 )
            {
                printToggle(edges, i);
            }

        }

    }

    public static void printDFSHelper( int edges[][], int sv, boolean visited[] )
    {
        System.out.print(sv + " ");
        visited[sv]= true;

        int n= edges.length;

        for( int i= 0; i< n; i++ )
        {
            if( edges[sv][i] == 1 && ! visited[i] )
            {
                printDFSHelper(edges, i, visited);
            }
        }

    }

    public static void printDFS( int edges[][] )
    {
        boolean visited[]= new boolean[edges.length];		// Size of the boolean array is same as the no of vertices

        for( int i= 0; i< edges.length; i++ )		// edges.length ki jagah visited.length bhi le sakte the. edges 2D array ek square matrix h
        {
            if( ! visited[i] )
            {
                printDFSHelper(edges, i, visited);
            }

        }

    }

    public static void printBFSHelper( int edges[][], int sv, boolean visited[] )
    {
        Queue<Integer> q= new LinkedList<>();

        q.add(sv);
        visited[sv]= true;

        while( ! q.isEmpty() )
        {
            int n= q.remove();
            System.out.print(n + " ");

            for( int i= 0; i<edges.length; i++ )
            {
                if( edges[n][i] == 1 && ! visited[i] )
                {
                    q.add(i);
                    visited[i]= true;
                }

            }

        }

    }

    public static void printBFS( int edges[][] )
    {
        boolean visited[]= new boolean[edges.length];

        for( int i= 0; i< edges.length; i++ )
        {
            if( ! visited[i] )
            {
                printBFSHelper( edges, i, visited );
            }
        }

    }

    public static boolean hasPathBFSHelper( int edges[][], boolean visited[], int SV, int EV )
    {
        Queue<Integer> q= new LinkedList<>();
        q.add(SV);
        visited[SV]= true;


        while( ! q.isEmpty() )
        {
            int n= q.remove();

            if( n == EV )
            {
                return true;
            }

            for( int i= 0; i<edges.length; i++ )
            {
                if( edges[SV][i] == 1 && ! visited[i] )
                {
                    q.add(i);
                    visited[i]= true;
                }

            }

        }

        return false;

    }

    public static boolean hasPathBFS( int edges[][], int SV, int EV )
    {
        boolean visited[]= new boolean[edges.length];

        return hasPathBFSHelper(edges, visited, SV, EV );

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

        System.out.println("DFS");
        printDFS(edges);

        System.out.println();

        System.out.println("BFS");
        printBFS(edges);

    }

}

