# Divide

## Information

- DATE: 2020.09.23
- LINK: [LeetCode-Problem29](https://leetcode-cn.com/problems/divide-two-integers/)
- TAG: `Binary search` `Bit operation`

## Description

> 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
>
> 返回被除数 dividend 除以除数 divisor 得到的商。
>
> 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
>
>  
>
> **示例** 1:
>
> ```
> 输入: dividend = 10, divisor = 3
> 输出: 3
> 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
> ```
>
> **示例** 2:
>
> ```
> 输入: dividend = 7, divisor = -3
> 输出: -2
> 解释: 7/-3 = truncate(-2.33333..) = -2
> ```
>
> **提示**：
>
> - 被除数和除数均为 32 位有符号整数。
> - 除数不为 0。
> - 假设我们的环境只能存储 32 位有符号整数，其数值范围是 $[−2^{31},  2^{31} − 1]$。本题中，如果除法结果溢出，则返回 $2^{31} − 1$。

## My Answer

- 遍历，时间复杂度为 $O(N)$ 超过了时间限制。

```java
class Solution {
    public int divide(int dividend, int divisor) {
        int sign = (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) ? -1 : 1;
        int res = 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(true){
            dividend -= divisor;
            if (dividend >= 0) res++;
            else break;
        }
        return res * sign;
    }
}
```

## Better Answer

```java
class Solution {
    int div;

    public int divide(int dividend, int divisor) {
        int sign = ( (dividend ^ divisor) < 0) ? -1 : 1;
        int res = 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        while(dividend <= divisor){
            int temp = divisor;
            int c = 1;

            while (dividend - temp <= temp){
                temp <<= 1;
                c <<= 1;
            }
            dividend -= temp;
            res += c;
        }
        return res * sign;
    }
}
```

- 位运算的应用
  - 不用乘法，快速得到两个数相乘/除的正负号：`int sign = ( (dividend ^ divisor) < 0) ? -1 : 1;`
  - 不用乘法，进行乘二以实现二分法：`temp <<= 1`