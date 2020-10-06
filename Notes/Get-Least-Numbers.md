# Get Least Numbers

## Information

- DATE: 2020.09.28
- LINK: [剑指 Offer 40](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)
- TAG: `quick selection` `heap sort`

## Description

> 输入整数数组 `arr` ，找出其中最小的 `k` 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
>
> **示例** 1：
>
> 输入：`arr = [3,2,1], k = 2`
> 输出：`[1,2]` 或者 `[2,1]`
>
> **示例** 2：
>
> 输入：`arr = [0,1,2,1], k = 1`
> 输出：`[0]`
>
> **限制**：
>
> `0 <= k <= arr.length <= 10000`
> `0 <= arr[i] <= 10000`

## Answer 1: heap sort

- 使用 Java 提供的 `PriorityQueue` 实现大根堆

  ```java
  class Solution {
      public int[] getLeastNumbers(int[] arr, int k) {
          if(k == 0) return new int[0];
          
          PriorityQueue<Integer> pQueue = new PriorityQueue<>();
  
          for(int i = 0; i < k; i++){ //默认为小根堆，通过去相反数获得大根堆
              pQueue.add(-arr[i]);
          }
  
          for(int i = k; i < arr.length; i++){
              if( -arr[i] > pQueue.peek()){
                  pQueue.remove();
                  pQueue.add(-arr[i]);
              }
          }
  
          int[] ans = new int[k];
          for(int i = 0; i < k; i++){
              ans[i] = -pQueue.remove();
          }
          return ans;
  
      }
  }
  ```

  - 时间复杂度：堆的插入与删除的时间复杂度都是 $O(nlogn)$，这里堆中的元素数量为 $k$, 故实际时间复杂度为 $O(nlogk)$
  - 空间复杂度：$O(K)$

## Answer 2: quick select

- 使用基于快速排序变换而来的快速选择，当某一次递归结束后 `i == k` 时，可知 `arr[0, i-1]` 即为前 k 个小数。

  ```java
  class Solution {
  	public int[] getLeastNumbers(int[] arr, int k) {
          if(k == 0) return new int[0];
      	//快速选择
          return quickSelect(arr, 0, arr.length-1, k);
  
      }
  
      private int[] quickSelect( int[ ] a, int left, int right, int k ){
          if (right <= left) return Arrays.copyOf(a, k);
          
          int pivot = median3( a, left, right );
          
          if (right - left <= 2) return Arrays.copyOf(a, k);
          
          // Begin partitioning 
          int i = left, j = right - 1;
          for(;;){
              while(  a[++i] < pivot ) { }
              while(  a[--j] > pivot ) { }
              if( i < j ) 
                  swapReference( a, i, j );
              else 
                  break;
          } 
          swapReference( a, i, right -1 ); // Restore pivot
          
          if( i == k ){
              return Arrays.copyOf(a, i);
          }else if( i < k ){
              return quickSelect(a, i + 1, right, k);
          }else{
              return quickSelect(a, left, i-1, k);
          }
      }	
  
      private int median3(int[] a, int left, int right){
          int mid = (left+right)>>1;
          
          //将最左、中间以及最右三个元素排序
          if(a[left] > a[mid] ){
              swapReference(a, left, mid);
          } 
          if(a[left] > a[right]) {
              swapReference(a, left, right);
          } 
          if(a[mid] > a[right]) {
              swapReference(a, mid, right);
          } 
          
          //将 pivot 放到次右的位置储存。
          //因已知最右的元素大于 pivot，故次右，而不是最右
          swapReference(a, mid, right-1);
          
          return a[right-1];
      }
  
      private void swapReference(int[] a, int i, int j){
          int tmp = a[i];
          
          a[i] = a[j];
          a[j] = tmp;
          
          return;
      }
  
  }   
  ```

  - 时间复杂度：小于快速排序的复杂度 $O(nlogn)$，可以证明平均时间复杂度为 $O(n)$
  - 空间复杂度：每次递归的时间复杂度为 $O(1)$，最多进行 $O(logn)$ 次递归，故时间复杂度为 $O(logn)$

## Notes

- 堆排序的优势
  - 空间复杂度低；
  - 可以接收数据流；
  - 不改变原始数据。
- 快速排序的优势
  - 时间复杂度更低
  - 可以就地进行。