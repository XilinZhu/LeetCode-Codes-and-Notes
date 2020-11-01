# Is-Balanced

## Information

- DATE: 2020.10.06
- LINK: [剑指 Offer 55-II](https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/)
- TAG:  `Balanced-Tree` ` Postorder traversal`

## Description

> 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
>
> **示例** 1:
> 给定二叉树 `[3,9,20,null,null,15,7]`
>
> ```
>          3
>         / \
>       9  20
>          /  \
>         15   7
> ```
>
> 返回 `true` 。
>
> **示例** 2:
> 给定二叉树 `[1,2,2,3,3,null,null,4,4]`
>
> ```
>            1
>           / \
>          2   2
>         / \
>        3   3
>      / \
>    4   4
> ```
>
>
> 返回 `false` 。
>
> **限制**：
> 1 <= 树的结点个数 <= 10000

## My Anawer : Preorder Traversal

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs( getDepth(root.left, 1) - getDepth(root.right, 1)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode root, int depth){
        if(root == null) return depth;
        depth++;
        
        return Math.max(getDepth(root.left, depth), getDepth(root.right, depth));
    }
}
```

- 最糟糕的情况下，在每个节点上都要向下遍历至叶子节点，时间复杂度为 $O(nlogn)$
- 当树退化为链表时，需要复杂度为 $O(n)$ 的栈空间

## Better Answer : Postorder Traversal

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return lrd(root) != -1;

    }

    private int lrd(TreeNode root){
        if(root == null) return 0;
        int left = lrd(root.left);
        if(left == -1) return -1;
        int right = lrd(root.right);
        if(right == -1) return -1;
        
        return (Math.abs(left - right) > 1) ? -1 : Math.max(left, right) + 1;
    }
}
```

- 时间复杂度，每个节点只被访问一次，故为 $O(N)$
- 空间复杂度与先序遍历相同

## Notes

- 树的遍历：自顶向下使用先序遍历，自底向上使用后序遍历。