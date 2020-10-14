# 实现strStr()

## Information

- DATE: 2020.08.21
- LINK: [LeetCode Problem 28](https://leetcode-cn.com/problems/implement-strstr/)
- TAG: `string` `Sunday` `double-pointer`

## Description

> 实现 `strStr()` 函数。
>
> 给定一个 `haystack` 字符串和一个 `needle` 字符串，在 `haystack` 字符串中找出 `needle` 字符串出现的第一个位置 (从 `0` 开始)。如果不存在，则返回  `-1`。
>
> 示例 1:
>
> 输入: `haystack = "hello", needle = "ll"`
> 输出: `2`
>
> **示例** 2:
>
> 输入: `haystack = "aaaaa", needle = "bba"`
> 输出: `-1`
>
> **说明**:
>
> 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
>
> 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
>

## Answer

```java
class Solution {
    // sunday算法
    public int strStr(String haystack, String needle) {
        // 各种边界情况
        if (haystack != null && haystack.equals(needle)) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        int j = 0;
        while(i + n <= m){
            //常规双指针
            j = 0; 
            while(j < n && haystack.charAt(i + j) == needle.charAt(j)){
                j++;
            }
            if(j == n){
                return i;
            }
            //Sunday的核心思想，总是从当前匹配字符串的后一位（暴力搜索中的下一次终点）向前寻找下一次的起点。最优情况下，总从暴力搜索的下一次终点作为下一次的起点，时间复杂度为不大于O(n)；最糟糕的情况下，时间复杂度为O(m+n)。
            int k = n - 1;
            while(k >= 0 && i + n < m && needle.charAt(k) != haystack.charAt(i+n)){
                k--;
            }
            i = k >= 0 ? i + n - k : i + n;   
        }
        return -1;
    }
}


```

