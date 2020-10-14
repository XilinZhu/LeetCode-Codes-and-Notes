# 572. Subtree of Another Tree

## Information

- DATE: 2020.08.11
- LINK: [LeetCode-Problem572]((https://leetcode-cn.com/problems/subtree-of-another-tree/))
- TAG: `Recursion` `Tree` 

## Description

> Given two non-empty binary trees `s` and `t`, check whether tree `t` has exactly the same structure and node values with a subtree of `s`.
>

## My Answer

- 利用二叉树的递归性质设计递归方法

- `isSame() ` 用来判断两棵是否完全相同。它和 `isSubtree` 的区别在于：当某个节点不同时，前者直接返回 `false`，而后者会继续探索 `s` 子树与 `t` 相同的可能性。

  ```java
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode() {}
   *     TreeNode(int val) { this.val = val; }
   *     TreeNode(int val, TreeNode left, TreeNode right) {
   *         this.val = val;
   *         this.left = left;
   *         this.right = right;
   *     }
   * }
   */
  class Solution {
      public boolean isSubtree(TreeNode s, TreeNode t) {
          if (t == null && s == null) 
              return true;
          else if (t == null || s == null)
              return false;
          else if (t.val == s.val && isSame(s, t))
              return true;
          else
              return isSubtree(s.left, t) || isSubtree(s.right, t);
      }
  
      private boolean isSame(TreeNode s, TreeNode t){
          if (t == null && s == null) 
              return true;
          else if (t == null || s == null)
              return false;
          else if (t.val == s.val)
              return  isSame(s.left, t.left) && isSame(s.right, t.right);
          else
              return false;
      }
  }
  ```

## Better Answer

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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;   // 空树一定是子树
        if (s == null) return false;  // 空树一定不包含非空子树
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s,t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true; //全为空
        if (s == null || t == null) return false; //在前一个判断基础上，可知一个为空，一个不为空
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
```

- 在逻辑上实现了进一步简化：
  - 由于 `t` 与 `s` 具有同步的指针，故若 `t == null` ，则 `s == null`
- 代码风格的启发：
  - 在不影响逻辑的情况下，使用多个单 `if` 语句，比 `if-elseif-elseif-else` 要简洁.
  - 在递归中，尽量头轻脚重：把较为复杂的语句放在末尾，这样能使得代码的可读性更强