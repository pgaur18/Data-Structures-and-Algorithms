package DynamicProgramming.DynamicProgramming2D;

public class EditDistance {

    public static int editDistance( String s, String t )
    {
        int m= s.length();
        int n= t.length();

        if( m == 0 || n == 0 )
        {
            return m == 0 ? n : m;
        }

        if( s.charAt(0) == t.charAt(0) )
        {
            return editDistance(s.substring(1), t.substring(1));
        }
        else
        {
            int op1= editDistance(s.substring(1), t);
            int op2= editDistance(s, t.substring(1));
            int op3= editDistance(s.substring(1), t.substring(1));

            int min= Math.min(op1, Math.min(op2, op3));

            return 1 + min;

        }

    }

    private static int editDistanceM( String s, String t, int storage[][] )
    {
        int m= s.length();
        int n= t.length();

        if( m == 0 || n == 0 )
        {
            int ans= m == 0 ? n : m;

            storage[m][n]= ans;

            return storage[m][n];

        }

        if( storage[m][n] != -1 )
        {
            return storage[m][n];

        }

        if( s.charAt(0) == t.charAt(0) )
        {
            storage[m][n]= editDistanceM(s.substring(1), t.substring(1), storage);

            return storage[m][n];

        }
        else
        {
            int op1= editDistance(s.substring(1), t);
            int op2= editDistance(s, t.substring(1));
            int op3= editDistance(s.substring(1), t.substring(1));

            int min= Math.min(op1, Math.min(op2, op3));

            storage[m][n]= 1 + min;

            return storage[m][n];

        }
    }

    public static int editDistanceM( String s, String t )
    {
        int storage[][]= new int[s.length()+1][t.length()+1];

        for( int i= 0; i<= s.length(); i++ )
        {
            for( int j= 0; j<= t.length(); j++ )
            {
                storage[i][j]= -1;

            }

        }

        return editDistanceM(s, t, storage);
    }

    public static int editDistanceDP( String s, String t )
    {

        int m= s.length();
        int n= t.length();

        int storage[][]= new int[m+1][n+1];

        // Base Case = fill the first row and column

        // First Row

        for( int j= 0; j<= n; j++ )
        {
            storage[0][j]= j;
        }

        // First column

        for( int i= 0; i<= m; i++ )
        {
            storage[i][0]= i;
        }



        for( int i= 1; i<= m; i++ )
        {
            for( int j= 1; j<= n; j++ )
            {
                if( s.charAt(m-i) == t.charAt(n-j) )
                {
                    storage[i][j]= storage[i-1][j-1];
                }
                else
                {
                    int op1= storage[i-1][j-1];
                    int op2= storage[i][j-1];
                    int op3= storage[i-1][j];

                    int min= Math.min(op1, Math.min(op2, op3));

                    storage[i][j]= 1 + min;

                }

            }

        }


        return storage[m][n];


    }

    public static void main(String[] args) {

        String s= "adef";
        String t= "bdef";

        System.out.println(editDistanceDP(s, t));
        System.out.println(editDistanceM(s, t));
        System.out.println(editDistance(s, t));

    }

}
