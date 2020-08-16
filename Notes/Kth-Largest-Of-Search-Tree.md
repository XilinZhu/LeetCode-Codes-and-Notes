

# Kth Largest Of Search Tree

## Information

- DATE: 2020.08.14
- LINK: [剑指 Offer 54](https://leetcode-cn.com/problemset/lcof/?topicSlugs=tree)
- TAG: `tree` `backtracing` `list`

## Description

> 给定一棵二叉搜索树，请找出其中第k大的节点。
>
>  
>
> **示例** 1:
>
> 输入: `root = [3,1,4,null,2], k = 1`
>
> ```
>    3
>   / \
>  1   4
>   \
>    2
> ```
>
> 输出: `4`
>
> **示例** 2:
>
> 输入: `root = [5,3,6,2,4,null,null,1], k = 3`
>       
>
> ```
>        5
>       / \
>      3   6
>     / \
>    2   4
>   /
>  1
> ```
>
> 输出: `4`

## My Answer

- 使用一个递增有序列表记录节点值，返回第 `lis.size()-k` 个值.

```java
class Solution {
    List<Integer> lis = new LinkedList<>();

    public int kthLargest(TreeNode root, int k) {
        setLis(root);
        return lis.get(lis.size()-k);
    }

    private void setLis(TreeNode root){
        if (root == null) return;
        setLis(root.left);
        lis.add(root.val);
        setLis(root.right);
    }
}
```

## Better Answer

- 不适用队列记录节点值，通过两个对象字段来记录当前状态.
- 虽然效率得到了提高，但这两种算法都因为全局变量的使用而不够优雅。其主要原因在于Java中的基本类型是按值传递的.

```java
class Solution {
    int k,res;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root){
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val; 
        dfs(root.left);
    }
}
```

