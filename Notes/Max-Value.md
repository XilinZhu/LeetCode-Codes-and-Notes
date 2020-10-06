# Max Value

## Information

- DATE: 2020.10.04
- LINK: [剑指 offer 47](https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/)
- TAG: `dynamic programming` 

## Description

> 在一个 `m*n` 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
>
>  
>
> **示例** 1:
>
> ```
> 输入: 
> [
>   [1,3,1],
>   [1,5,1],
>   [4,2,1]
> ]
> 输出: 12
> ```
>
> **解释**: 路径 1→3→5→2→1 可以拿到最多价值的礼物
>
> **提示**：
>
> `0 < grid.length <= 200`
> `0 < grid[0].length <= 200`

## Answer

```java
class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for(int i = 0, j = 1; j < n; j++){
            grid[i][j] += grid[i][j-1];
        }
        for(int j = 0, i = 1; i < m; i++){
            grid[i][j] += grid[i-1][j];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
        
    }
}
```

- 解题思路简洁，故能顺藤摸瓜得到简洁的代码：在寻找最大求和路径时，不从前往后看，而是从后往前看，得出每个位置能获得的最大和。