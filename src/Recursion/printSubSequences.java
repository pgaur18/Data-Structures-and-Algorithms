package Recursion;

public class printSubSequences {

    public static void printSubSeqHelper(String input, String outputSoFar )
    {
        if( input.length() == 0 )
        {
            System.out.println(outputSoFar);
            return;
        }

        printSubSeqHelper(input.substring(1), outputSoFar);
        printSubSeqHelper(input.substring(1), outputSoFar + input.charAt(0));

    }

    public static void printSubSeq( String input )
    {
        printSubSeqHelper(input, "");
    }

    public static void main(String[] args) {

        printSubSeq("xy");

    }

}
