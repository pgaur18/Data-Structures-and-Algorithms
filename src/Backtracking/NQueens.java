package Backtracking;

public class NQueens {

    public static void placeNQueens( int n )
    {
        int board[][]= new int[n][n];

        placeQueens(board, 0, n);		// board, starting row, n
    }

    public static boolean isBoardSafe( int board[][], int row, int col )
    {
        int n= board.length;

        for( int i= row-1, j= col-1; i>= 0 && j>= 0; i--, j-- )		// top left diagnol
        {
            if( board[i][j] == 1)
            {
                return false;
            }
        }

        for( int i= row+1, j= col+1; i< n && j< n; i++, j++ )			// bottom right diagnol
        {
            if( board[i][j] == 1 )
            {
                return false;
            }
        }

        for( int i= row-1, j= col+1; i>= 0 && j< n; i--, j++ )			// top right diagnol
        {
            if( board[i][j] == 1 )
            {
                return false;
            }
        }

        for( int i= row+1, j= col-1; i< n && j>= 0; i++, j--)		// bottom left diagnol
        {
            if( board[i][j] == 1 )
            {
                return false;
            }

        }

        for( int i= row-1; i>= 0; i-- )		//		top
        {
            if( board[i][col] == 1 )
            {
                return false;
            }
        }

        for( int i= row+1; i< n; i++ )		// 		down
        {
            if( board[i][col] == 1 )
            {
                return false;
            }
        }

        return true;

    }

    public static void placeQueens( int board[][], int row, int n )
    {
        if( row == n )
        {
            // valid configuration

            for( int i= 0; i< n; i++ )
            {
                for( int j= 0; j< n; j++ )
                {
                    System.out.print(board[i][j] + " ");
                }

                System.out.println();

            }

            System.out.println();

        }

        // check for all columns in a row
        for( int j= 0; j< n; j++ )
        {
            // check if it is safe to place the Queen

            if( isBoardSafe(board, row, j) )
            {
                board[row][j]= 1;

                // If it safe then place the queen and move to next row

                placeQueens(board, row+1, n);

                board[row][j]= 0;

            }

        }

    }

    public static void main(String[] args) {

        int n= 4;
        placeNQueens(n);

    }

}
