# Min Array

## Information

- DATE: 2020.09.25
- LINK: [剑指 Offer 11](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)
- TAG: `binary search`

## Decription

> 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
>
> **示例** 1：
>
> `输入：[3,4,5,1,2]`
> `输出：1`
>
> **示例** 2：
>
> `输入：[2,2,2,0,1]`
> `输出：0`

## My Answer

```java
class Solution {
    public int minArray(int[] numbers) {
        return minArray(numbers, 0 , numbers.length-1);
    }
    private int minArray(int[] numbers, int left, int right){
        if(left == right) return numbers[left]; 
        int mid = (left+right)/2;
        
        int minLeft = Math.min(numbers[left], numbers[mid]);
        int minRight = Math.min(numbers[mid+1], numbers[right]);

        if (minLeft < minRight){
            return minArray(numbers, left, mid);
        }else if (minLeft > minRight){
            return minArray(numbers, mid+1, right);
        }         
        else{
            return Math.min(minArray(numbers, left, mid) , minArray(numbers, mid+1, right));
        }
    }
}
```

- 难点在于：获得最小元素所在的区间范围。为解决此问题，我使用了 `minLeft` 和 `minRight`
  - 此想法基于这样一个事实：包含最小元素的区间一定在其两个端点的其中之一取得4个端点中的最小值。

## Better Answer

```java
class Solution {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length-1;
        while(i < j){
            int mid = (i + j)/2;
            if (numbers[mid] > numbers[j]){
                i = mid+1;
            }else if (numbers[mid] < numbers[j]){
                j = mid;
            }else{
                j--;
            }
        }
        return numbers[i];
    }
}
```

- 分析略，可分别考虑 `numbers[mid] > numbers[j]` 时，左区间为递增区间或非递增区间的情况
- 关键点：使用了 `j--` 这一辅助变化来解决元素重复导致死循环的情况。