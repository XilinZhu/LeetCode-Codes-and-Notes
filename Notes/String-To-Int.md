# O-67. 把字符串转换成整数

## Information

- DATE: 2020.08.21
- LINK: [剑指 Offer 67](https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/)
- TAG: `string` `char`

## Description

> 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
>
> 说明：
>
> 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 $[−2^{31},  2^{31} − 1]$。如果数值超过这个范围，请返回 `INT_MAX` 或 `INT_MIN` 。
>
> **示例** 1:
>
> **输入**: `"42"`
> **输出**: `42`
>
> **示例** 2:
>
> **输入**: `"   -42"`
> **输出**: `-42`
> **解释**: *第一个非空白字符为 `'-'`, 它是一个负号。我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42* 。
>
> **示例** 3:
>
> **输入**: `"4193 with words"`
> **输出**: `4193`
> **解释**: *转换截止于数字 `'3'` ，因为它的下一个字符不为数字。*
>
> **示例** 4:
>
> **输入**: `"words and 987"`
> **输出**: `0`
> **解释**: *第一个非空字符是 `'w'`, 但它不是数字或正、负号。因此无法执行有效的转换。*
>
> **示例** 5:
>
> **输入**: `"-91283472332"`
> **输出**: `-2147483648`
> **解释**: *数字 `"-91283472332"` 超过 32 位有符号整数范围。 因此返回 `INT_MIN` 。*

## My Answer

```java
class Solution {
    public int strToInt(String str) {
        str = str.trim();
        str = str.split(" ")[0];
        if (str.length() == 0) return 0;
        Character c= str.charAt(0);
        long ans = 0;
        Map<Character, Integer> nums = new HashMap<>();
        nums = Map.of(
            '1',1, '2',2, '3',3, '4',4, '5',5,
            '6',6, '7',7, '8',8, '9',9, '0',0
        );
        if( nums.containsKey(c) || c == '+' || c == '-'){
            if (nums.containsKey(c)){
                ans = nums.get(c);
            }
            
            for( int i = 1; i < str.length(); i++){
                if( nums.containsKey(str.charAt(i)))
                    ans = ans*10 + nums.get(str.charAt(i));
                else
                    break;
                if ( ans > Integer.MAX_VALUE)
                    break;
            }

            if (c == '-')
                ans = Math.max(-ans, Integer.MIN_VALUE);
            else
                ans = Math.min(ans, Integer.MAX_VALUE);
        }
        return (int)ans;             
    }
}
```

## My Better Answer

- 不使用 `map` ，而是用字符运算来实现数字字符到整数的转换

```java
public class StringToInt {
    public int strToInt(String str) {
        str = str.trim();
        str = str.split(" ")[0];
        if (str.length() == 0) return 0;
        int curr, first = str.charAt(0) - 48;
        long ans = 0;

        if( first >= 0 && first <= 9 || first == -5 || first == -3){ // 48: 0, 43: +, 45: -
            if (first >= 0 && first <= 9){
                ans = first;
            }
            
            for( int i = 1; i < str.length(); i++){
                curr = str.charAt(i) - 48 ;
                if( curr >= 0 && curr <= 9)
                    ans = ans*10 + curr;
                else
                    break;
                if ( ans > Integer.MAX_VALUE)
                    break;
            }

            if (first == -3)
                ans = Math.max(-ans, Integer.MIN_VALUE);
            else
                ans = Math.min(ans, Integer.MAX_VALUE);
        }
        return (int)ans;             
    }
}
```

## Even Better Answer

- 不作 `str = str.split(" ");`，而是在遇到空格时停下；
- 关于溢出监测，使用 `ans > boundary || ans == boundary && curr > 7` ；
- 关于字符的运算，使用 `'+'` `'-'` `'0'` 而不是 `43` `45` `48` ，这样能提高代码的可读性.

```java
class Solution {
    public int strToInt(String str) {
        str = str.trim();

        if (str.length() == 0) return 0;
        int curr, first = str.charAt(0), boundary = Integer.MAX_VALUE/10;
        int ans = 0;

        if( first >= '0' && first <= '9' || first == '+' || first == '-'){
            if (first >= '0' && first <= '9'){
                ans = first - '0';
            }
            
            for( int i = 1; i < str.length(); i++){
                curr = str.charAt(i) - '0' ;
                if( curr < 0 || curr > 9) 
                    break;
                if ( ans > boundary || ans == boundary && curr > 7)
                    return (first == '-') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                ans = ans*10 + curr;
            }
            ans = (first == '-') ? -ans : ans; 
        }
        return ans;             
    }
}
```

## My Notes

1. **字符运算**：不使用 `map` ，而是用字符运算来实现数字字符到整数的转换；
2. **溢出监测**：使用 `ans > boundary || ans == boundary && curr> 7`；
3. **字符运算**：使用 `'+'` `'-'` `'0'` 而不是 `43` `45` `48` ，这样能提高代码的可读性.