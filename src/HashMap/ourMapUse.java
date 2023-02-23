package HashMap;

public class ourMapUse {

    public static void main(String[] args) {

        Map<String, Integer> map= new Map<String, Integer>();

        for( int i=0; i<20; i++)
        {
            map.insert("findMissingAndRepeating_DS450"+ i, 1+i);
            System.out.println("i = "+ i+ " Lf = "+ map.loadFactor());
        }

        map.removeKey("abc3");
        map.removeKey("abc7");

        for( int i=0; i<20; i++)
        {
            System.out.println("findMissingAndRepeating_DS450 :"+ i + ":"+ map.getValue("findMissingAndRepeating_DS450"+ i));
        }
    }

}

