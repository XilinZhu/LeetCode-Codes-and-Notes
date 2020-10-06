# Find Nth Digit

## Information

- DATE: 2020.10.04
- LINK: [剑指 Offer 44](https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/)
- TAG: `Math` `Big-Integer`

## Description

> 数字以 0123456789101112131415… 的格式序列化到一个字符序列中。在这个序列中，第 5 位（从下标 0 开始计数）是 5，第 13 位是 1 ，第 19 位是 4 ，等等。
>
> 请写一个函数，求任意第 n 位对应的数字。
>
>  
>
> **示例** 1：
>
> 输入：`n = 3`
> 输出：`3`
>
> **示例** 2：
>
> 输入：`n = 11`
> 输出：`0`
>
> **限制**：
>
> `0 <= n < 2^31`

## Answer

```java
class Solution {
    public int findNthDigit(int n) {
        long start = 1;
        int digit = 1;
        long count = 9;

        while( n > count){
            n -= count;
            digit += 1;
            start *= 10;
            count = start * 9 * digit;
        }

        long num = start + (n-1) / digit ;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}

```

- 因为限制中指出 `0 <= n < 2^31`，而 `int` 的最大值为 `2^15-1` ，所以要考虑使用 `long`
- 注意将数据类型 `long` 转换为字符串时，使用的静态方法 `Long.toString()`
- 令 `start = 1`, 最后计算时使用 `(n-1)` 都是优化后的结果