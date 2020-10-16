# O-59 I.滑动窗口的最大值

# Information

- DATE: 2020.08.19
- LINK: [剑指 offer 59](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)
- TAG: `Deque` `slidingWindow`

## Description

> 给定一个数组 `nums` 和滑动窗口的大小 `k`，请找出所有滑动窗口里的最大值。
>
> **示例**:
>
> **输入**: `nums = [1,3,-1,-3,5,3,6,7]`, 和 `k = 3`
> **输出**: `[3,3,5,5,6,7]` 
> **解释:** 
>
> ```
>   滑动窗口的位置                最大值
> ---------------               -----
> [1  3  -1] -3  5  3  6  7       3
>  1 [3  -1  -3] 5  3  6  7       3
>  1  3 [-1  -3  5] 3  6  7       5
>  1  3  -1 [-3  5  3] 6  7       5
>  1  3  -1  -3 [5  3  6] 7       6
>  1  3  -1  -3  5 [3  6  7]      7
> ```
>
>
> 提示：
>
> 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
>

## My Answer

- 剪枝：当新移出的元素不等于上次的最大值时，新的最大值可由原最大值与新加入的元素比较产生.

  ```java
  if ( nums[ i - 1 ] == max ) 
      max = findMax(nums, i, i + k );  // find a new max in the whole window range
  else
      max = Math.max( max, nums[ i + k - 1] ); // in this case, the new max must be the old max or the new element
  ```

```java
public int[] maxSlidingWindow(int[] nums, int k) {
        if ( nums.length == 0 ) return new int[0];
    	if (k == 1) return nums;
    
        int numOfWindows = nums.length - k + 1;
        int[] res = new int[ numOfWindows ];
    	//initialize max
        int max = findMax(nums, 0, k);
        res[ 0 ] = max;

        for ( int i = 1; i < numOfWindows; i++ ){
            if ( nums[ i - 1 ] == max ) 
                max = findMax(nums, i, i + k );
            else
                max = Math.max( max, nums[ i + k - 1] );
            res[ i ] = max;
        }
        
        return res;
    }

    private int findMax(int[] nums, int start, int end){
        int max = Integer.MIN_VALUE;
        for( int i = start; i < end; i++){
            if( nums[ i ] > max ) max = nums[ i ];
        }
        return max;
    }
}
```

- 时间复杂度：$O(N\cdot k)$，当重复元素较少时，实际运行是更快的.
- 空间复杂度：$O(N - k +1)$，用于输出数组.

## General Answer

- 使用双向链表，并保持其非严格递减性
  - 新加入的点一定在之前所有点之后被弹出，所以一切小于它的值都可以从队尾弹出；

```java
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if ( nums.length == 0 ) return new int[0];
        if (k == 1) return nums;
        
        int numOfWindows = nums.length - k + 1;
        int[] res = new int[ numOfWindows ];
        LinkedList<Integer> lis = new LinkedList<>();
        int i;
		
        // initialize the list with the first k elements in nums
        for ( i = 0; i < k; i++){
            while ( !lis.isEmpty() && nums[ i ] > lis.getLast() ) lis.pollLast();
            lis.addLast( nums[ i ] );
        }
        res[0] = lis.getFirst();

        for ( i = 1; i < numOfWindows; i++ ){
            if ( nums[ i - 1 ] == lis.getFirst()) 
                lis.pollFirst();
            while ( !lis.isEmpty() && nums[ i + k - 1] > lis.getLast() )
                lis.pollLast();
            lis.addLast( nums[ i + k - 1] );
            res[i] = lis.getFirst();
        }
        return res;
    }
}   
```

- 时间复杂度：$O(N)$ ，每个元素的访问次数的花费为 $O(N)$ ，每个元素最多一次入队和出队，花费为 $O(2N)$，元素比较次数为 $O(N)$ 总时间复杂度为 $O(N)$
- 空间复杂度：$O(N)$，输出数组的空间复杂度为 $O(N-k+1)$ ，双向队列的空间复杂度为 $O(k)$

## Another General Answer

- 双向链表中存储索引，但反而增加了数组的访问次数

```java
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
}
```

- 时间复杂度：$O(N)$ ，每个元素的访问次数的花费为 $O(N)$ ，每个元素最多一次入队和出队，花费为 $O(2N)$，总时间复杂度为 $O(N)$
- 空间复杂度：$O(N)$，输出数组的空间复杂度为 $O(N-k+1)$ ，双向队列的空间复杂度为 $O(k)$

## My Notes

- 除了实际运行时间，时间复杂度也是一个重要的分析角度. 实际运行时间长者可能拥有更低的时间复杂度.
- 双向队列适合用于设计滑动窗口.