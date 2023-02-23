package Strings;

public class reverse_String_Wordwise {

    public static String reverseStringWordWise( String input )
    {
        String arr[]= input.split(" ");

        String answer= "";

        for( int i= arr.length-1; i>= 0; i-- )
        {
            answer+= arr[i] + " ";
        }

        return answer;

    }
    public static void main(String[] args) {

        String input= "Welcome To Coding";

        String answer= reverseStringWordWise(input);

        System.out.println(answer);

    }
}
