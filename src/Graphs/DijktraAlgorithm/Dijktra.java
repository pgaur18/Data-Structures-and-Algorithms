package Graphs.DijktraAlgorithm;
import java.util.*;
public class Dijktra {

    public static int findMinVertex( int distance[], boolean visited[] )
    {
        int minVertex= -1;

        for( int i= 0; i< distance.length; i++ )
        {
            if( ! visited[i] && ( minVertex == -1 || distance[i] < distance[minVertex] ) )
            {
                minVertex= i;
            }

        }

        return minVertex;
    }

    public static void dijktra( int edges[][] )
    {
        boolean visited[]= new boolean[edges.length];
        int distance[]= new int[edges.length];

        distance[0]= 0;

        for( int i= 1; i< distance.length; i++ )
        {
            distance[i]= Integer.MAX_VALUE;
        }

        for( int i = 0; i< edges.length; i++ )
        {
            // Find vertex with minimum distance

            int minVertex= findMinVertex(distance, visited);
            visited[minVertex]= true;

            for( int j= 0; j< edges.length; j++ )
            {
                if( edges[minVertex][j] != 0 && ! visited[j] && distance[minVertex] != Integer.MAX_VALUE )//distance[minVertex] != Integer.MAX_VALUE
                {																						// vertex source se infinite distance par nhi h
                    int newDistance= edges[minVertex][j] + distance[minVertex];

                    if( newDistance < distance[j] )
                    {
                        distance[j]= newDistance;
                    }

                }

            }

        }
        //Print

        for( int i= 0; i< edges.length; i++ )
        {
            System.out.println(i + " " + distance[i] );
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

//		0 vertex is considered as source

        dijktra(edges);

//		Input
//		5 7
//		0 1 4
//		0 2 8
//		1 3 5
//		1 2 2
//		2 3 5
//		2 4 9
//		3 4 4

    }

}
