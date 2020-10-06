# Last Remaining

## Information

- DATE: 2020.10.06
- LINK: [剑指 Offer 62](https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/)
- TAG:  `自建循环链表` `math`

## Description

> `0,1,,n-1` 这 `n` 个数字排成一个圆圈，从数字 `0` 开始，每次从这个圆圈里删除第 `m` 个数字。求出这个圆圈里剩下的最后一个数字。
>
> 例如，`0、1、2、3、4` 这 `5` 个数字组成一个圆圈，从数字 `0` 开始每次删除第 `3` 个数字，则删除的前 `4` 个数字依次是 `2、0、4、1`，因此最后剩下的数字是 `3` 。
>
> **示例** 1：
>
> `输入: n = 5, m = 3`
> `输出: 3`
>
> **示例** 2：
>
> `输入: n = 10, m = 17`
> `输出: 2`
>
> **限制**：
>
> `1 <= n <= 10^5`
> `1 <= m <= 10^6`

## Answer

```java
class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> lis = new ArrayList<>();

        for(int i = 0; i < n; i++){
            lis.add(i);
        }

        int idx = 0;
        int size = n;
        for(int i = 0; i < n - 1; i++){
            idx = (idx + m - 1)%size;
            lis.remove(idx);
            size--;
        }

        return lis.get(0);
    }
}
```

- `ArrayList` 与 `LinkedList` ，虽然就删除操作本身而言，`LinkedList` 的时间复杂度仅为 $O(1)$，但搜索节点需要花费 $O(N)$ 的时间复杂度。通过比较发现，在 `List.remove(int index)` 的实现上，`ArrayList` 具有更低的时间复杂度。  

