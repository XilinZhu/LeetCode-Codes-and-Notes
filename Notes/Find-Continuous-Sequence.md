# Find Continuous Sequence

## Information

- DATE: 2020.10.06
- LINK: [剑指 Offer 57-II](https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/)
- TAG: `Moving-Window`

## Description

> 输入一个正整数 `target` ，输出所有和为 `target` 的连续正整数序列（**至少含有两个数**）。
>
> 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
>
> **示例** 1：
>
> 输入：`target = 9`
> 输出：`[[2,3,4],[4,5]]`
>
> **示例** 2：
>
> 输入：`target = 15`
> 输出：`[[1,2,3,4,5],[4,5,6],[7,8]]`
>
> **限制**：
>
> `1 <= target <= 10^5`

## My Answer

```java
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new LinkedList<>();
        int i =1 , j = 2;
        while( i < j || j < target/2 + 1){
            while( (i + j)*(j-i+1)/2 < target){
                j++;
            }
            while( (i + j)*(j-i+1)/2 > target){
                i++;
            }
            if ((i + j)*(j-i+1)/2 == target){
                int[] tmp = new int[j-i+1];{
                    for(int p = 0; p < tmp.length; p++){
                        tmp[p] = i+p;
                    }
                }
                ans.add(tmp);
                i++;
            }
        }

        return ans.toArray(new int [ans.size()][]);

    }

    
}
```

## Better Answer

```java
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new LinkedList<>();
        int i =1 , j = 2;
        int sum = i + j; //滑动窗口通常会利用一个中间变量储存当前状态。这个状态根据窗口的形态变化作有规律的变化，从而不必每次重新计算状态。
        while( i < j || j <= target/2 + 1){
            while( sum < target){
                sum += ++j;
            }
            while( sum > target){
                sum -= i++;
            }
            if (sum == target){
                int[] tmp = new int[j-i+1];{
                    for(int p = 0; p < tmp.length; p++){
                        tmp[p] = i+p;
                    }
                }
                ans.add(tmp);
                sum -= i++;
            }
        }
        
        return ans.toArray(new int [ans.size()][]);
    }

    
}
```

## Notes

1. 滑动窗口的状态变量：滑动窗口通常会利用一个中间变量储存当前状态。这个状态根据窗口的形态变化作有规律的变化，从而不必每次重新计算状态。