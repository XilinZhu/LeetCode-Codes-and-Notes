# Hamming Weight

## Information

- DATE: 2020.09.28
- LINK: [剑指 Offer 15](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/)
- TAG: `Bit-operation` `Math`

## Description

> 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
>
> **示例** 1：
>
> 输入：`00000000000000000000000000001011`
> 输出：`3`
> 解释：输入的二进制串 `00000000000000000000000000001011` 中，共有 `3` 位为 `'1'`。
>
> **示例** 2：
>
> 输入：`00000000000000000000000010000000`
> 输出：`1`
> 解释：输入的二进制串 `00000000000000000000000010000000` 中，共有 `1` 位为 `'1'`。
>
> **示例** 3：
>
> 输入：`11111111111111111111111111111101`
> 输出：`31`
> 解释：输入的二进制串 `11111111111111111111111111111101` 中，共有 `31` 位为 `'1'`。

## Answer

```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;

        while(n != 0){
            ans += n & 1;
            n >>>= 1;
        }

        return ans;
    }
}
```

## Notes

- 利用位运算判断二进制第一位是否为1：`(n & 1) == 1`
- 利用位运算遍历二进制的每一位：`n >>>= 1` （无符号数）