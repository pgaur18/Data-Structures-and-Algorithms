package HashMap;

import java.util.*;

public class Map< K, V> {

    ArrayList<MapNode<K,V>> buckets;
    int size;  // total entries. we will use this so that we do not have to traverse LinkedList for size
    int numBuckets;

    public Map()
    {
        buckets= new ArrayList<>();
        numBuckets=5;

        for( int i=0; i<numBuckets; i++)
        {
            buckets.add(null);
        }

    }

    private int getBucketIndex( K key )
    {
        int hC= key.hashCode();

        return hC % numBuckets;
    }

    public double loadFactor()
    {
        return ( 1.0 * size)/numBuckets;

    }

    private void reHash()
    {
        System.out.println("ReHashing: Buckets :"+ numBuckets+ " size: "+ size);

        ArrayList<MapNode<K, V>> temp= buckets;
        buckets= new ArrayList<>();

        for( int i=0; i< 2*numBuckets; i++)
        {
            buckets.add(null);
        }

        size= 0;
        numBuckets*= 2;

        for( int i=0; i<temp.size(); i++ )
        {
            MapNode<K, V> head= temp.get(i);

            while( head != null )
            {
                K key= head.key;
                V value= head.value;
                insert(key, value);

                head=head.next;

            }

        }

    }

    public void insert( K key, V value )
    {
        int bucketIndex= getBucketIndex( key);

        MapNode<K, V> head= buckets.get(bucketIndex);

        while( head != null )
        {
            if( head.key.equals(key) )
            {
                head.value= value;
                return;
            }

            head= head.next;
        }

        head= buckets.get(bucketIndex);

        MapNode<K, V> newNode= new MapNode<>(key, value);
        size++;

        newNode.next= head;
        buckets.set(bucketIndex, newNode);

        double loadFactor=  ( 1.0 * size)/ numBuckets;// Use the method loadFactor()

        if( loadFactor > 0.7 )
        {
            reHash();
        }

    }

    public V getValue( K key )
    {
        int bucketIndex= getBucketIndex(key);

        MapNode<K, V> head= buckets.get(bucketIndex);

        while( head != null )
        {
            if( head.key.equals(key) )
            {
                return head.value;
            }
        }

        return null;

    }

    public V removeKey( K key )
    {
        int bucketIndex= getBucketIndex(key);
        MapNode<K, V> head= buckets.get(bucketIndex);

        MapNode<K, V> slow= null;

        while( head != null )
        {
            if( head.key.equals(key) )
            {
                size--;

                if( slow == null )
                {
                    buckets.set(bucketIndex, head.next);
                }
                else
                {
                    slow.next= head.next;
                }

                return head.value;
            }

            slow= head;
            head= head.next;
        }

        return null;

    }

    public int size()
    {
        return size;
    }

}

