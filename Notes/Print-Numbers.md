# Print Numbers

## Information

- DATE: 2020.09.28
- LINK: [剑指 Offer 17](https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/)
- TAG: `Big-Integer-Problem` `Math`

## Description

> 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
>
> **示例** 1:
>
> 输入: `n = 1`
> 输出: `[1,2,3,4,5,6,7,8,9]`
>
> **说明**：
>
> - 用返回一个整数列表来代替打印
> - n 为正整数

## Answer

```java
class Solution {
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;

        dfs(0);
        return res;
    }

    private void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(nine == n - start) start--;
            return;
        }

        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}
```

## Notes

- 使用字符串来实现大数
- 用字符数组表示大数时，低位对应了大索引
- 利用循环和遍历来避开字符串进位问题
- 除去开头的0
  - 当前数字的位数
  - 当遍历到全9数字时，从下一个数字开始，位数+1