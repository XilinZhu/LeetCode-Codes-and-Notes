# O28. Symmetric Tree

## Information

- DATE: 2020.08.16
- LINK: [剑指 offer 28](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/)
- TAG: `Tree` `Recursion` `Iteration`

## Description

> 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
>
> 例如，二叉树 `[1,2,2,3,4,4,3]` 是对称的。
>
> ```
>     1
>    / \
>   2   2
>  / \ / \
> 3  4 4  3
> ```
>
> 但是下面这个 `[1,2,2,null,3,null,3]` 则不是镜像对称的:
>
> ```
>   1
>  / \
>   2   2
>    \   \
>    3    3
> ```
> **示例** 1：
>
> 输入：`root = [1,2,2,3,4,4,3]`
> 输出：`true`
> **示例** 2：
>
> 输入：`root = [1,2,2,null,3,null,3]`
> 输出：`false`
>
> **限制：**
>
> ```
> 0 <= 节点个数 <= 1000
> ```

## Answer 1 : Recursion

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q){
        if(p == null && q ==null) return true;
        if(p == null || q == null || p.val != q.val) return false;
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);

    }
}
```

## Answer 2: Iteration

- 借助队列是将递归算法改为迭代算法的常见方式.
- `LinkList` 允许 `null` 入队

```java
class Solution {
	public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> lis = new LinkedList<>();
        TreeNode left;
        TreeNode right;
        lis.addLast(root);
        lis.addLast(root);
        while(!lis.isEmpty()){
            left = lis.pollFirst();
            right = lis.pollFirst();
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            
            lis.addLast(left.left);
            lis.addLast(right.right);
            lis.addLast(left.right);
            lis.addLast(right.left);
        }
        return true;
    }
}
```

