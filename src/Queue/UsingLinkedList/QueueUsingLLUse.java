package Queue.UsingLinkedList;

public class QueueUsingLLUse {

    public static void main(String[] args) {

        QueueUsingLL<Integer> q= new QueueUsingLL<>();

        q.Enqueue(10);
        q.Enqueue(20);
        q.Enqueue(30);
        q.Enqueue(40);

        System.out.println(q.size());

    }

}
