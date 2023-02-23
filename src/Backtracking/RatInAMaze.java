package Backtracking;

public class RatInAMaze {

    public static boolean ratInMaze( int maze[][] )
    {
        int n= maze.length;

        int path[][]= new int[n][n];

        return solveMaze(maze, 0, 0, path);		// maze, startIndex, EndIndex, path

    }

    public static boolean solveMaze( int maze[][], int i, int j, int path[][] )
    {
        // first thing to do is check whether i,j cell is valid or not
        //We have checked i,j conditions first because if they are invalid and we check maze[i][j] first then it will give out of bound exception

        if( i < 0 || i >= maze.length || j < 0 || j >= maze.length )
        {
            return false;
        }

        // If cell is valid but it is blocked

        if( maze[i][j] == 0 )
        {
            return false;
        }

        // If cell is already a part of our path

        if( path[i][j] == 1 )
        {
            return false;
        }

        //All the 3 conditions can be combined
        //But for better clarity we have written separately

        // Include the current path
        path[i][j]= 1;

        // Destination condition

        if( i == maze.length-1 && j == maze.length-1 )
        {
            for( int r= 0; r< path.length; r++ )
            {
                for( int c= 0; c< path.length; c++ )
                {
                    System.out.print(path[r][c] + " ");
                }

                System.out.println();

            }
            return true;
            // No need to travel further
        }

        // Explore other cells if it was not the destination cell. 4 possible directions

        if( solveMaze( maze, i-1, j, path ) )		// Top
        {
            return true;
        }

        if( solveMaze(maze, i, j+1, path) )			// Right
        {
            return true;
        }

        if( solveMaze(maze, i+1, j, path) )			// Down
        {
            return true;
        }

        if( solveMaze(maze, i, j-1, path) )			// Left
        {
            return true;
        }

        return false;

    }

    public static void printPaths( int maze[][] )
    {
        int n= maze.length;

        int path[][]= new int[n][n];

        printAllPossiblePaths(maze, 0, 0, path);		// maze, startIndex, EndIndex, path

    }

    public static void printAllPossiblePaths( int maze[][], int i, int j, int path[][] )
    {
        if( i < 0 || i >= maze.length || j < 0 || j >= maze.length )
        {
            return;
        }

        // If cell is valid but it is blocked

        if( maze[i][j] == 0 )
        {
            return;
        }

        // If cell is already a part of our path

        if( path[i][j] == 1 )
        {
            return;
        }

        //All the 3 conditions can be combined
        //But for better clarity we have written separately

        // Include the current path
        path[i][j]= 1;

        // Destination condition
        if( i == maze.length-1 && j == maze.length-1 )
        {
            for( int r= 0; r< path.length; r++ )
            {
                for( int c= 0; c< path.length; c++ )
                {
                    System.out.print(path[r][c] + " ");
                }

                System.out.println();

            }

            System.out.println();

            path[i][j]= 0;

            return;
            // No need to travel further

        }

        // Explore other cells if it was not the destination cell. 4 possible directions

        printAllPossiblePaths(maze, i-1, j, path);		// Top

        printAllPossiblePaths(maze, i, j+1, path);		// Right

        printAllPossiblePaths(maze, i+1, j, path);		// Down

        printAllPossiblePaths(maze, i, j-1, path);		// Left

        path[i][j]= 0;

    }

    public static void main(String[] args) {

        int maze[][]= { {1,1,0}, {1,1,0}, {1,1,1} };

        boolean isPathPossible= ratInMaze(maze);

        System.out.println(isPathPossible);

        System.out.println();

        printPaths(maze);

    }

}
