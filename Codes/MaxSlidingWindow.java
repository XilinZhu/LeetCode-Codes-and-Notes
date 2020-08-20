import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if ( nums.length == 0 ) return new int[0];
        if (k == 1) return nums;
        int numOfWindows = nums.length - k + 1;
        int[] res = new int[ numOfWindows ];
        
        Deque<Integer> lis = new LinkedList<>();
        int i;

        for ( i = 0; i < k; i++){
            while ( !lis.isEmpty() && nums[ i ] > nums [ lis.getLast()] ) lis.pollLast();
            lis.addLast( i );
        }
        res[0] = nums[ lis.getFirst() ];

        for ( i = k; i < nums.length; i++ ){
            if ( i - k  == lis.getFirst()) lis.pollFirst();
            while ( !lis.isEmpty() && nums[ i ] > nums [ lis.getLast()] ) lis.pollLast();
            lis.addLast( i );
            res[i - k ] = nums [ lis.getFirst()];
        }

        return res;
    }

    public static void main(String[] args) {
        MaxSlidingWindow w = new MaxSlidingWindow();
        int [] nums = {7,2,4};
        int k = 2;
        w.maxSlidingWindow(nums, k); 
    }
}

/* //my answer
public int[] maxSlidingWindow(int[] nums, int k) {
    if ( nums.length == 0 ) return new int[0];
    int numOfWindows = nums.length - k + 1;
    int[] res = new int[ numOfWindows ];
    int max = findMax(nums, 0, k);

    for ( int i = 1; i < numOfWindows; i++ ){
        if ( nums[ i ] == max ) 
            max = findMax(nums, i, i + k - 1 );
        else
            max = Math.max( max, nums[ i + k - 1] );
        res[ i ] = max;
    }
    
    return res;
}


private int findMax(int[] nums, int start, int end){
    int max = Integer.MIN_VALUE;
    for( int i = start; i < end; i++){
        if( nums[ i ] > max) max = nums[ i ];
    }
    return max;
} */

/* Another Answer based on deque
public int[] maxSlidingWindow(int[] nums, int k) {
    if ( nums.length == 0 ) return new int[0];
    if (k == 1) return nums;
    int numOfWindows = nums.length - k + 1;
    int[] res = new int[ numOfWindows ];
    
    LinkedList<Integer> lis = new LinkedList<>();
    int i;

    for ( i = 0; i < k; i++){
        while ( !lis.isEmpty() && nums[ i ] > lis.getLast() ) lis.pollLast();
        lis.addLast( nums[ i ] );
    }
    res[0] = lis.getFirst();

    for ( i = 1; i < numOfWindows; i++ ){
        if ( nums[ i - 1 ] == lis.getFirst()) lis.pollFirst();
        if ( !lis.isEmpty() && nums[ i + k - 1] > lis.getLast() ){
            do
                lis.pollLast();
            while (!lis.isEmpty() && nums[ i + k - 1] > lis.getLast());
            lis.addLast( nums[ i + k - 1] );
        } 

        res[i] = lis.getFirst();
    }

    return res;
} */