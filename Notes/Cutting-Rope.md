# Cutting-Rope

## Information

- DATE: 2020.09.28
- LINK: [剑指 Offer 14-II.](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/)
- TAG: `Big-Integer-Problem  `  `Math`

## Description

> 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 `m` 段（`m`、`n`都是整数，`n>1`并且`m>1`），每段绳子的长度记为 `k[0],k[1]...k[m - 1]` 。请问 `k[0]*k[1]*...*k[m - 1]` 可能的最大乘积是多少？例如，当绳子的长度是 `8` 时，我们把它剪成长度分别为 `2、3、3` 的三段，此时得到的最大乘积是 `18`。
>
> 答案需要取模 `1e9+7（1000000007）`，如计算初始结果为：`1000000008`，请返回 `1`。
>
> **示例** 1：
>
> 输入: `2`
> 输出: `1`
> 解释: `2 = 1 + 1, 1 × 1 = 1`
>
> **示例** 2:
>
> 输入: `10`
> 输出: `36`
> 解释: `10 = 3 + 3 + 4, 3 × 3 × 4 = 36`
>
>
> 提示：
>
> `2 <= n <= 1000`

## Answer

```java
class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        long res=1L;
        int p=(int)1e9+7;
        //贪心算法，优先切三，其次切二
        while(n>4){
            res=res*3%p;
            n-=3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (int)(res*n%p);
    }
}
```

- 数学：每段为3时，乘积最大，为4或2次之；
- 大数求余：循环求余，$x^a⊙p=[(x^{a−1}⊙p)(x⊙p)]⊙p=[(x^{a−1}⊙p)x]⊙p$，由于都小于$p$，所以简化为 $(x^{a-1}x)⊙p$