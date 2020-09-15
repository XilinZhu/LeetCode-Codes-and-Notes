import java.util.*;

public class MinNumber {
	public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];

        //整型数组 -> 字符串数组
        for(int i = 0; i < nums.length; i++) 
            strs[i] = String.valueOf(nums[i]);

        //将lambda表达式定义的比较器传入 Array.sort() 方法
        mergeSort(strs);

        return strs.toString();
    }

    /**
    * Internal method that makes recursive calls.
    * @param a an array of Comparable items.
    * @param tmpArray an array to place the merged result.
    * @param left the left-most index of the subarray.
    * @param right the right-most index of the subarray.
    */
    void mergeSort( String [] a,  String [] tmpArray, int left, int right ){
        if( left < right ) {
            int center = ( left + right ) /2; 
            mergeSort( a, tmpArray, left, center ); 
            mergeSort( a, tmpArray, center + 1, right );
            merge( a, tmpArray, left, center + 1, right ); 
        }
    }

    /** * Mergesort algorithm. 
    * @param a an array of Comparable items.
    */
    public void mergeSort( String [ ] a){
        String [ ] tmpArray = new String[a.length];
        mergeSort( a, tmpArray, 0, a.length - 1 );
    }

    /** * Internal method that merges two sorted halves of a subarray.
    * @param a an array of Comparable items.
    * @param tmpArray an array to place the merged result.
    * @param leftPos the left-most index of the subarray.
    * @param rightPos the index of the start of the second half.
    * @param rightEnd the right-most index of the subarray.
    */ 
    private void merge( String [ ] a, String [ ] tmpArray, int leftPos, int rightPos, int rightEnd ){
        int leftEnd = rightPos - 1; 
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos +1; 
        // Main loop 
        while( leftPos <= leftEnd && rightPos <= rightEnd ){
            if( MyComparator.compare(a[leftPos], a[rightPos]) <= 0 ){
                tmpArray[ tmpPos++ ] = a[ leftPos++ ];
            } else{
                tmpArray[ tmpPos++ ] = a[ rightPos++ ]; 
            } 
        }
            
        while( leftPos <= leftEnd ){ // Copy rest of first half 
            tmpArray[ tmpPos++ ] = a[ leftPos++ ];
        }  
        while( rightPos <= rightEnd ){ // Copy rest of right half 
            tmpArray[ tmpPos++ ] = a[ rightPos++ ];
        } 

        // Copy tmpArray back 
        for( int i = 0;i < numElements; i++, rightEnd-- ) {
            a[ rightEnd ] = tmpArray[ rightEnd ];
        }
    }

    Comparator<String> MyComparator = (s1, s2)-> (s1+s2).compareTo(s2+s1);

    public static void main(String[] args) {
        MinNumber s= new MinNumber();
        int[] nums = {0,9,8,7,6,5,4,3,2,1};
        s.minNumber(nums);
    }
}