package Tries;

import java.util.*;

public class ourTrieUse {

    public static void main(String[] args) {

//		Trie t= new Trie();
//
//		t.add("this");
//		t.add("news");
//
//		System.out.println(t.search("news"));
//		t.remove("news");
//		System.out.println(t.search("news"));



//		Trie t2= new Trie();
//
//		t2.add("a");
//		System.out.println(t2.search("a"));
//		t2.remove("a");
//		System.out.println(t2.search("a"));
//
//		Trie t3= new Trie();
//
//		t3.add("a");
//		System.out.println(t3.search("a"));
//		t3.removeBetter("a");
//		System.out.println(t3.search("a"));


        ArrayList<String> ar= new ArrayList<>();

        ar.add("abc");
        ar.add("def");

        for( String s : ar )
        {
            for(int i= 0; i<s.length(); i++ )
            {
                System.out.println(s.substring(i));
            }

        }

    }

}

