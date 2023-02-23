package Queue.UsingArray;

public class DynamicQueueUse {

    public static void main(String[] args) {

        DynamicQueue q= new DynamicQueue(3);

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
