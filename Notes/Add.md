# Add

## Information

- DATE: 2020.10.06
- LINK: [剑指 Offer 65](https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/)
- TAG: `bit-operation`

## Description

> 写一个函数，求两个整数之和，要求在函数体内不得使用 `“+”、“-”、“*”、“/”` 四则运算符号。
>
> **示例**:
> 输入: `a = 1, b = 1`
> 输出: `2`
>
> **提示**：
> `a, b` 均可能是负数或 0
> 结果不会溢出 32 位整数

## Answer

```java
class Solution {
    public int add(int a, int b) {
        while(b != 0){
            int c = (a & b) << 1; //计算进位值
            a ^= b; //得到无进位中间结果
            b = c; //保存这一步的进位
        }
        return a;
    }
}
```

## Notes

- 计算机系统中，整数是以补码形式保存的，所以作加法的时候不用考虑正负号问题。
- 使用位运算的加法由三部分组成：计算进位制、计算无进位中间结果，保存当前的进位。循环，直到进位值为 0.

