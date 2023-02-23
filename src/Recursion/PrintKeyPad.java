package Recursion;

public class PrintKeyPad {

    public static char[] charOptions( int no )
    {
        if( no == 2 )
        {
            char arr[]= {'a', 'b', 'c'};
            return arr;
        }
        else if( no == 3 )
        {
            char arr[]= {'d', 'e', 'f'};
            return arr;
        }
        else if( no == 4 )
        {
            char arr[]= {'g', 'h', 'i'};
            return arr;
        }
        else if( no == 5 )
        {
            char arr[]= {'j', 'k', 'l'};
            return arr;
        }
        else if( no == 6 )
        {
            char arr[]= {'m', 'n', 'o'};
            return arr;
        }
        else if( no == 7 )
        {
            char arr[]= {'p', 'q', 'r', 's'};
            return arr;
        }
        else if( no == 8 )
        {
            char arr[]= {'t', 'u', 'v'};
            return arr;
        }
        else
        {
            char arr[]= {'w', 'x', 'y', 'z'};
            return arr;
        }


    }

    public static void printKeyPadHelper( int n, String outputSoFar)
    {
        if( n == 0 )
        {
            System.out.println(outputSoFar);
            return;
        }

        char arr[]= charOptions( n % 10 );

        for( int i=0; i< arr.length; i++ )
        {
            printKeyPadHelper(n/10, arr[i] + outputSoFar);
        }

    }

    public static void printKeyPad( int n )
    {
        printKeyPadHelper(n, "");
    }

    public static void main(String[] args) {


        printKeyPad(223);


    }

}

