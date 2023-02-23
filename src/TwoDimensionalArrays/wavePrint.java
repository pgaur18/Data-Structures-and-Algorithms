package TwoDimensionalArrays;

public class wavePrint {

    public static void main(String[] args) {

        int arr[][]= { {1,2,3}, {4,5,6}, {7,8,9} };

        for( int i= 0; i< arr.length; i++ )
        {
            int m= arr.length-1;

            for( int j= 0; j< arr.length; j++ )
            {

                if( i % 2 == 0 )
                {
                    System.out.print(arr[j][i] + " ");
                }
                else
                {
                    System.out.print(arr[m][i] + " ");
                    m--;
                }

            }

        }

    }

}
