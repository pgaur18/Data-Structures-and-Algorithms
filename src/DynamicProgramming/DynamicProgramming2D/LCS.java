package DynamicProgramming.DynamicProgramming2D;

public class LCS {

    public static int lcs( String s, String t )
    {
        if( s.length() == 0 || t.length() == 0 )
        {
            return 0;
        }

        if( s.charAt(0) == t.charAt(0) )
        {
            return 1 + lcs(s.substring(1), t.substring(1) );
        }
        else
        {

            int op1= lcs(s, t.substring(1));
            int op2= lcs(s.substring(1), t);
//			int op3= lcs(s.substring(1), t.substring(1));		// without option 3 our code works because the initial op3 is calculated inside op1 or op2
//
//			return Math.max(op1, Math.max(op2, op3));

            return Math.max(op1, op2);

        }

    }

    private static int lcsM( String s, String t, int storage[][] )
    {
        int m= s.length();
        int n= t.length();

        if( m == 0 || n == 0 )	// kisi bhi String ki length 0 ho gayi toh answer is zero
        {
            storage[m][n]= 0;

            return storage[m][n];

        }

        if( storage[m][n] != -1 )
        {
            return storage[m][n];
        }



        if( s.charAt(0) == t.charAt(0) )
        {
            storage[m][n]= 1 + lcsM(s.substring(1), t.substring(1) );

            return storage[m][n];

        }
        else
        {

            int op1= lcs(s, t.substring(1));
            int op2= lcs(s.substring(1), t);

            storage[m][n]= Math.max(op1, op2);

            return storage[m][n];

        }

    }

    public static int lcsM( String s, String t )
    {
        int storage[][]= new int[s.length() + 1 ][t.length() + 1];

        for( int i= 0; i< s.length() + 1; i++ )
        {
            for( int j= 0; j< t.length() + 1; j++ )
            {
                storage[i][j]= -1;		// To distinguish that cell calculated h ya nhi
            }

        }

        return lcsM(s, t, storage);

    }

    public static int lcsDP( String s, String t )
    {
        int m= s.length();
        int n= t.length();

        int storage[][]= new int[m+1][n+1];

        // Base Case

        // Row 1 full zeroes
        for( int i= 0; i<=m; i++ )
        {
            storage[i][0]= 0;
        }

        // Column 1 full zeroes
        for( int j= 0; j<=n; j++ )
        {
            storage[0][j]= 0;
        }


        for( int i= 1; i<= m; i++ )
        {
            for( int j= 1; j<= n; j++ )
            {
                if( s.charAt(m-i) == t.charAt(n-j) )
                {
                    // first char same
                    storage[i][j]= 1 + storage[i-1][j-1];

                }
                else
                {
                    int op1= storage[i][j-1];
                    int op2= storage[i-1][j];

                    storage[i][j]= Math.max(op1, op2);

                }

            }

        }

        return storage[m][n];

    }

    public static void main(String[] args) {

        String s= "adef";
        String t= "deaf";

        System.out.println(lcsDP(s, t));
        System.out.println(lcsM(s, t));
        System.out.println(lcs(s, t));


    }

}
