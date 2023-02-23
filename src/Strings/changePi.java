package Strings;

public class changePi {
    static int i;
    static String ans;

    public static void replacePiRecursive( String s ) {
        if (i >= s.length()) {
            return;
        }

        if (s.charAt(i) == 'p') {
            if (i + 1 < s.length() && s.charAt(i + 1) == 'i') {
                ans += 3.14;
                i += 2;
            } else {
                ans += s.charAt(i);
                i++;
            }

        } else {
            ans += s.charAt(i);
            i++;
        }

        replacePiRecursive(s);

    }

    public static void main(String[] args) {

        String s= "pippiippip";

        i= 0;
        ans= "";
        replacePiRecursive(s);
        System.out.println(ans);

    }


}
