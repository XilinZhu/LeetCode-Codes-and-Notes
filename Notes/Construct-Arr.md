# Construct Arr

## Information

- DATE: 2020.10.09
- LINK: [剑指 offer 66](https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/)
- TAG: `traversal` 

## Description

> 给定一个数组 `A[0,1,…,n-1]`，请构建一个数组 `B[0,1,…,n-1]`，其中 B 中的元素 `B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]`。不能使用除法。
>
> **示例**:
>
> 输入: `[1,2,3,4,5]`
> 输出: `[120,60,40,30,24]`
>
>
> 提示：
>
> 所有元素乘积之和不会溢出 32 位整数
> `a.length <= 100000`

## Answer

```java
class Solution {
    public int[] constructArr(int[] a) {
        if(a.length == 0) return new int[0];

        int len = a.length;
        int[] res = new int[len];
        
        res[0] = 1;
        for(int i = 1; i < len; i++){
            res[i] = res[i-1] * a[i-1];
        }

        int tmp = 1;
        for(int i = len - 2; i >= 0; i--){
            tmp *= a[i+1];
            res[i] *= tmp;
        }

        return res;
    }
}
```

- 利用两次遍历实现特定元素的剔除。
- ==#TODO: 可视化==