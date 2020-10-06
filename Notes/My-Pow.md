# My Pow

## Information

- DATE: 2020.09.28
- LINK: [剑指 Offer 16](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/)
- TAG: `Bit-operation` `Math`

## Description

> 实现函数`double Power(double base, int exponent)`，求 `base` 的 `exponent` 次方。不得使用库函数，同时不需要考虑大数问题。
>
>  
>
> **示例** 1:
>
> 输入: `2.00000, 10`
> 输出: `1024.00000`
>
> **示例** 2:
>
> 输入: `2.10000, 3`
> 输出: `9.26100`
>
> **示例** 3:
>
> 输入: `2.00000, -2`
> 输出: `0.25000`
>
> **说明**:
>
> `-100.0 < x < 100.0`
> `n` 是 32 位有符号整数，其数值范围是 $[−2^{31}, 2^{31} − 1] $。

## Answer

```java
class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        
        if(b < 0){
            b *= -1;
            x = 1/x;
        }

        double res = 1;
        while(b > 0){
            if ( (b & 1) == 1){
                res *= x;
            }
            b >>>= 1;
            x *= x;
        }

        return res;
    }
}
```

## Notes

- 利用位运算判断整数能否被2整除：`(b & 1) == 1`

- 计算幂函数的巧妙思路

  <img src="https://i.loli.net/2020/09/28/AjaRonlMy5mNKvz.png" style="zoom:50%;" />