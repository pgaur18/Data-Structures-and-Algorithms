package Stack;
import java.util.*;

public class duplicateBrackets {

    public static boolean hasDuplicateBrackets( String str )
    {
        Stack<Character> st= new Stack<>();

        if( str == null )
        {
            return true;
        }

        for( int i=0; i<str.length(); i++ )
        {
            char ch= str.charAt(i);

            if( ch == ')' )
            {
                if( st.peek() == '(' )
                {
                    return false;
                }

                else
                {
                    while( st.peek() != '(' )
                    {
                        st.pop();
                    }

                    st.pop();

                }

            }

            else
            {
                st.push(ch);
            }

        }

        if( st.size() == 0 )
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public static void main(String[] args) {

        String str= "((a+b)+(c+d))";
        boolean bool= hasDuplicateBrackets(str);
        System.out.println(bool);

    }

}

