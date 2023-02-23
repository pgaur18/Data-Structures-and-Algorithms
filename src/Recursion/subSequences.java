package Recursion;

public class subSequences {

    public static String[] Helper( String s )
    {

        if( s.length() == 0 )
        {
            String ans[]= {""};
            return ans;
        }

        String smallAns[]= Helper(s.substring(1));

//		length of new Array  = smallAns + (smallAns*x) = 2*smallAns         , for sub-seq of xyz

        String ans[]= new String[2 * smallAns.length];

        for( int i=0; i< smallAns.length; i++ )
        {
            ans[i]= smallAns[i];

        }

        for( int i= 0; i< smallAns.length; i++ )
        {
            ans[i + smallAns.length ]= s.charAt(0) + "" + smallAns[i];

        }

        return ans;

    }

    public static void main(String[] args) {

        String s= "xyz";
        String arr[]= Helper(s);

        System.out.println("Sub Sequences of xyz are : ");

        for( String str : arr )
        {
            System.out.println(str);
        }

    }

}

