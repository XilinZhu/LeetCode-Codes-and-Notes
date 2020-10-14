# Permution

# Information

- DATE: 2020.09.25
- LINK: [剑指 offer 38](https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/)
- TAG: `Backtracking` `string`

## Description

> 输入一个字符串，打印出该字符串中字符的所有排列。
>
> 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
>
> **示例**:
>
> ```
> 输入：s = "abc"
> 输出：["abc","acb","bac","bca","cab","cba"]
> ```
>
> **限制**：
>
> `1 <= s 的长度 <= 8`

## Answer

```java
class Solution {
    public String[] permutation(String s) {
        char[] cs = s.toCharArray();
        Set<String> combines = new HashSet<>();
        StringBuilder combine = new StringBuilder();
        int ind = 0;
        dfs(cs, combines, combine, ind);

        
        return combines.toArray(new String[0]);
    }

    private void dfs(char[] cs, Set<String> combines, StringBuilder combine, int ind){
        if (ind == cs.length){
            combines.add(combine.toString());
            return;
        }
        
        //不交换,深度优先
        combine.append(cs[ind]);
        dfs(cs, combines, combine, ind+1);
        combine.deleteCharAt(ind);

        //交换
        for(int i = ind+1; i < cs.length; i++){
            if(cs[i] == cs[ind]) continue;
            swap(cs, i, ind);
            combine.append(cs[ind]);
            dfs(cs, combines, combine, ind+1);
            combine.deleteCharAt(ind);
            swap(cs, i, ind);
        }
        
    }

    private void swap(char[] cs, int i, int j){
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
```

## Notes

- 回溯算法模板
  - 变量：全局容器、局部容器、深度计数；
  - 递归内容：终止条件、深度优先、回溯向下一广度搜索；
  - 要点：在每次递归的前后作对称的操作，使得总可以回溯到上一层的状态。