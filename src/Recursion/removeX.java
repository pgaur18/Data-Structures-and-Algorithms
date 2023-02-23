package Recursion;

public class removeX {

    public static String Helper( String s )
    {
        if( s.length() == 0 )
        {
            return s;
        }

        String ans= "";

        if( s.charAt(0) != 'x' )
        {
            ans+= s.charAt(0) + "";
        }

        String small= Helper(s.substring(1));

        ans+= small;

        return ans;

    }

    public static void main(String[] args) {

        String s= "xxxxxa";

        System.out.println("Old String is : " + s);
        System.out.println("New String is : " + Helper(s));

    }

}
