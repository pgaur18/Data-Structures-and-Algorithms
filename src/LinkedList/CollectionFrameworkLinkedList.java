package LinkedList;
import java.util.*;

public class CollectionFrameworkLinkedList {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.addFirst(50);

        System.out.println("Size is : " + list.size());

        for (Integer i : list) {
            System.out.print(i + ", ");
        }

        System.out.println();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

    }
}
