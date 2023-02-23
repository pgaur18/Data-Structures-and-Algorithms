package Graphs.PrimsAlgorithm;

import java.util.*;

public class Prims {

    public static int findMinVertex( int weight[], boolean visited[] )
    {
        int minVertex= -1;

        for( int i= 0; i< weight.length; i++ )
        {
            if( ! visited[i] && ( minVertex == -1 || weight[i] < weight[minVertex] ) )
            {
                minVertex= i;
            }

        }

        return minVertex;

    }

    public static void prims( int edges[][] )
    {
        boolean visited[]= new boolean[edges.length];
        int parent[]= new int[edges.length];
        int weight[]= new int[edges.length];

        weight[0]= 0;
        parent[0]= -1;

        for( int i= 1; i< edges.length; i++ )
        {
            weight[i]= Integer.MAX_VALUE;
        }

        for( int i= 0; i< edges.length; i++ )
        {
            // Pick vertex with minimum Edge
            int minVertex= findMinVertex(weight, visited);

            visited[minVertex]= true;		// mark it visited

            // Explore its neighbours

            for( int j= 0; j< edges.length; j++ )
            {
                if( edges[minVertex][j] != 0 && ! visited[j] )
                {
                    if( edges[minVertex][j] < weight[j] )
                    {
                        weight[j]= edges[minVertex][j];
                        parent[j]= minVertex;
                    }

                }

            }

        }

        // Print edges of MST

        // i == 1 se start hoga because 0 ka parent -1 h

        for( int i= 1; i< edges.length; i++ )
        {
            if( parent[i] < i )
            {
                System.out.println(parent[i] + " " + i + " " + weight[i] );
            }
            else
            {
                System.out.println(i + " " + parent[i] + " " + weight[i] );
            }

        }

    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        int v= sc.nextInt();
        int e= sc.nextInt();

        int edges[][]= new int[v][v];

        for( int i= 0; i< e; i++ )
        {
            int v1= sc.nextInt();
            int v2= sc.nextInt();
            int weight= sc.nextInt();

            edges[v1][v2]= weight;
            edges[v2][v1]= weight;

        }

        prims(edges);

    }

}
