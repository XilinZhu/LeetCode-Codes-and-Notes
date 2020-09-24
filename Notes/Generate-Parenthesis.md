# Generate Parenthesis

## Information

- DATE: 2020.09.24
- LINK: [LeetCode-Problem22](https://leetcode-cn.com/problems/generate-parentheses/)
- TAG: `string` `dynamic programming`

## Description

> 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
>
> **示例**：
>
> ```
> 输入：n = 3
> 输出：[
>        "((()))",
>        "(()())",
>        "(())()",
>        "()(())",
>        "()()()"
>      ]
> ```

## Answer

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> total = new ArrayList<>(n+1);
        total.add(new LinkedList<String>(Arrays.asList("")));
        total.add(new LinkedList<String>(Arrays.asList("()")));

        if(n <= 1) return total.get(n);

        for(int i = 2; i <= n; i++){
            List<String> curr = new LinkedList<>();
            for (int p = 0; p < i; p++){
                int q = i - 1 - p;
                for (String s1 : total.get(p)){
                    for (String s2: total.get(q)){
                        curr.add("(" + s2 + ")" + s1);
                    }
                }
            }
            total.add(curr);
        }
        return total.get(n);
    }
}
```

- 此题适合使用动态规划的理由：
  - 初始状态清晰
  - 直接求解困难
  - 递推关系随无法直接想到，但可以一试