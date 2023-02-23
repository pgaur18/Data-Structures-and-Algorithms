package Queue.UsingArray;

public class QueueUsingArrayUse {

    public static void main(String[] args) {


        QueueUsingArray q= new QueueUsingArray();

        for( int i= 1; i<= 5; i++ )
        {
            try
            {
                q.Enqueue(i);
            }
            catch (QueueFullException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        while( ! q.isEmpty() )
        {
            try
            {
                System.out.println(q.Dequeue());

            }
            catch(QueueEmptyException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}
