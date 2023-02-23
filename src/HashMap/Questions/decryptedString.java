package HashMap.Questions;

public class decryptedString {

    public static void fullString( String str )
    {
        int i=1;

        while( i < str.length() )
        {
            char ch= str.charAt(i-1);
            for( int j=0; j< str.charAt(i)-'0'; j++ )
            {
                System.out.print(ch);

            }

            i+=2;

        }

    }

    public static void main(String[] args) {

        String str= "a4b3c2d1";
        fullString(str);


    }

}
