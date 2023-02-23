package Stack;
import java.util.*;

public class balancedBrackets {

    public static boolean checkClosing( Stack<Character> st, char corrOp )
    {
        if( st.size() == 0 )
        {
            System.out.println("Extra clsong brackets");
            return false;
        }
        if( st.peek() != corrOp )
        {
            return false;
        }
        else
        {
            st.pop();
            return true;
        }

    }

    public static boolean hasBalancedBrackets( String str )
    {
        if( str == null )
        {
            return true;
        }

        Stack<Character> st= new Stack<>();

        for( int i=0; i< str.length(); i++ )
        {
            char ch= str.charAt(i);

            if( ch == '(' || ch =='{' || ch== '[' )
            {
                st.push(ch);
            }

            else if( ch == ')' )
            {
                boolean bool= checkClosing(st, '(');
                if( bool == false )
                {
                    return false;
                }
            }

            else if( ch == '}' )
            {
                boolean bool= checkClosing(st, '{');
                if( bool == false )
                {
                    return false;
                }
            }

            else
            {
                boolean bool= checkClosing(st, '[');
                if( bool == false )
                {
                    return false;
                }
            }

        }

        if( st.size() > 0 )
        {
            System.out.println("Extra opening brackets");
            return false;
        }

        else
        {
            return true;
        }


    }

    public static void main(String[] args) {

        String str= "{()}]";
        boolean bool= hasBalancedBrackets(str);
        System.out.println(bool);
    }

}

