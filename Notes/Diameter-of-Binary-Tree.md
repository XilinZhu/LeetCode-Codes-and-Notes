# 543. Diameter of Binary Tree

## Information

- DATE: 2020.08.12
- LINK: [LeetCode-Problem543](https://leetcode-cn.com/problems/diameter-of-binary-tree/)
- TAG: `Tree` `Recursion` 

## Description

> Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
>
> ```
>  		  1
>          / \
>         2   3
>        / \     
>       4   5    
> ```
>
> return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
>
> **Note**: The length of path between two nodes is represented by the number of edges between them.

## Answer

- 涉及到树的题目，尽量使用递归。这是数的定义所决定的。
- 难点：在递归计算深度 `depth` 的同时，更新 `maxDiameter` 

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root); 
        return maxDiameter;
    }

    private int getDepth(TreeNode t){
        if (t == null) return 0;
        int lDepth = getDepth(t.left);
        int rDepth = getDepth(t.right);
        maxDiameter = Math.max( lDepth + rDepth, maxDiameter);
        return Math.max(lDepth, rDepth) + 1;
    }
}
```

## Notes

- 类中的字段可以被所有的方法访问，这为在递归方法中更新外部变量提供了基础。