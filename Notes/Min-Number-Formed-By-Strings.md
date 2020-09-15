# Min Number Formed By Strings

## Information

- DATE: 2020.09.11
- LINK: [剑指 Offer 45](https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)
- TAG: `sort` `string`

## Description

> 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
>
> 
>
> 示例 1:
>
> `输入: [10,2]`
> `输出: "102"`
>
> 示例 2:
>
> `输入: [3,30,34,5,9]`
> `输出: "3033459"`
>
>
> 提示:
>
> - `0 < nums.length <= 100`
>
> 说明:
>
> - 输出结果可能非常大，所以你需要返回一个字符串而不是整数
> - 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0

## Answer 1: quick sort based on code model

```java
class Solution {
	public String minNumber(int[] nums) {
        int len = nums.length;
        String[] strs = new String[len];
    
    	//将整型数组转换为字符串数组
        for( int i = 0; i < len; i++ ){
            strs[i] = String.valueOf(nums[i]);
        }
    
    	//快速排序
        quicksort(strs, 0, len-1);
    
    	//将字符串数组连接为一个单独的字符串，速度快于 String.join("",strs);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
    
        return res.toString();
    }

    private void quicksort( String[ ] a, int left, int right ){
        if (right <= left) return;
        
        String pivot = median3( a, left, right );
        
        if (right - left <= 2) return;
        
        // Begin partitioning 
        int i = left, j = right - 1;
        for(;;){
            while( MyComparator.compare( a[++i], pivot) < 0 ) { }
            while( MyComparator.compare( a[--j], pivot) > 0 ) { }
            if( i < j ) 
                swapReference( a, i, j );
            else 
                break;
        } 
        swapReference( a, i, right -1 ); // Restore pivot
        
        quicksort( a, left, i-1 );	//sort small elements
        quicksort( a, i, right);	//sort large elements
    }	

    private String median3(String[] a, int left, int right){
        int mid = (left+right)>>>1;
        
        //将最左、中间以及最右三个元素排序
        if(MyComparator.compare(a[left], a[right]) > 0){
            swapReference(a, left, right);
        } 
        if(MyComparator.compare(a[left], a[mid]) > 0){
            swapReference(a, left, mid);
        } 
        if(MyComparator.compare(a[mid], a[right]) > 0){
            swapReference(a, mid, right);
        } 
        
        //将 pivot 放到次右的位置储存。
        //因已知最右的元素大于 pivot，故次右，而不是最右
        swapReference(a, mid, right-1);
        
        return a[right-1];
    }

    private void swapReference(String[] a, int i, int j){
        String tmp = a[i];
        
        a[i] = a[j];
        a[j] = tmp;
        
        return;
    }

    Comparator<String> MyComparator = (s1, s2)-> (s1+s2).compareTo(s2+s1);
}   
```

- 利用三值中位数法进行了 `pivot` 选择

## Answer 2: quick sort based on built-in function

```java
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];

        //整型数组 -> 字符串数组
        for(int i = 0; i < nums.length; i++) 
            strs[i] = String.valueOf(nums[i]);

        //将lambda表达式定义的比较器传入 Array.sort() 方法
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));

        //将字符串数组连接为数组，速度快于 String.join("",strs);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);

        return res.toString();
    }
}
```

## Answer 3: insertion sort based on code model

```java
class Solution {
    public String minNumber(int[] nums) {
        int len = nums.length;
        String[] strs = new String[len];
    
    	//将整型数组转换为字符串数组
        for( int i = 0; i < len; i++ ){
            strs[i] = String.valueOf(nums[i]);
        }
    
    	//快速排序
        insertionSort(strs, 0, len-1);
    
    	//将字符串数组连接为数组，速度快于 String.join("",strs);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
    
        return res.toString();
    }

    private void insertionSort(String[] a, int left, int right){
        int j;
    
        for( int p = 1; p< a.length; p++){
            String tmp = a[ p ];
            for( j = p; j > 0 && MyComparator.compare( tmp, a[j - 1]) < 0; j-- ){
                a[ j ] = a[ j-1 ];
            }
                a[ j ] = tmp;
        }
    }

    Comparator<String> MyComparator = (s1, s2)-> (s1+s2).compareTo(s2+s1);
}
```

## Answer 4: mergesort based on code model

```java
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];

        //整型数组 -> 字符串数组
        for(int i = 0; i < nums.length; i++) 
            strs[i] = String.valueOf(nums[i]);

        mergeSort(strs);

        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
    
        return res.toString();
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
}
```

## Note

- 字符串数组转字符串：`StringBuilder` `.append()` `.toString`，速度快于 `String.join("",strs)` ；
- 直接修改 `Array.sort(arr, Comparator)` 的比较器参数，是一种比较巧妙的排序拓展方法.