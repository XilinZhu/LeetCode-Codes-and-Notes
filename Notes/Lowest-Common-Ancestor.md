# Lowest Common Ancestor

## Information

- DATE: 2020.08.15
- LINK: [剑指 Offer 68](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)
- TAG: `tree ` `Postorder traversal`

## Description

> 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
>
> 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
>
> 例如，给定如下二叉树:  `root = [3,5,1,6,2,0,8,null,null,7,4]`
>
> ![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/15/binarytree.png)
>
> **示例** 1:
>
> 输入: `root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1`
> 输出: `3`
> 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
>
> **示例** 2:
>
> 输入: `root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4`
> 输出: `5`
> 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。

## My Answer

- 使用两个标志位来记录目标节点的查找情况.
- 使用后序遍历.
- 为了区分两个节点在同一棵子树和不在同一棵子树的情况，在左节点遍历完，进入右节点之前，记录当前查找状态后重置状态.

```java
class Solution {
    Boolean foundP = false, foundQ = false;
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lrd(root, p, q);
        return ans;
    }

    public void lrd(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return;
        
        lrd(root.left, p, q);

        boolean hasP = foundP, hasQ = foundQ;
        foundP = false;
        foundQ = false;

        lrd(root.right, p, q);

        if (ans != null) return;
        if(root.val == p.val) 
            foundP = true;
        if(root.val == q.val) 
            foundQ = true;

        foundP = foundP || hasP;
        foundQ = foundQ || hasQ;
        if(foundP && foundQ){
            ans = root;
            foundP = false;
        }  
    }
}
```

## Better Answer

- 可提问：两个节点是否一定存在于树中？

- **不需要同时找到两个节点**，比如在示例 2 中，只要在左子树找到了 5，那么接下来就只需要确认，即与 5 同级别的右子树中是否有另一个节点 4——若没有，则节点 4 必是5的子节点，返回 5；若有，则公共祖先必是5的父节点

  ```java
  class Solution {
      public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          if(root == null || root == p || root == q) return root;
          //后序遍历，左右子树顺序可交换
          TreeNode left = lowestCommonAncestor(root.left, p, q);
          TreeNode right = lowestCommonAncestor(root.right, p, q);
  		//如何向上返回？答：若左子树没有，右子树也没有，且已知根节点也不是，则向上返回null；若左（右）子树空，右（左）子树不空，则返回右（左）子树；若各自找到，则返回根节点。
          //题目的另一种理解：找到一个最低的根节点，它同时包含两个子节点。因为要求最低，所以作后序遍历
          if(left == null && right == null) return null;
          if(left == null) return right; //目标节点出现的位置
          if(right == null) return left; //目标节点出现的位置
          return root;
      }
  }
  ```

- **充分分析题目条件，首先在逻辑上对诸多情况进行简化**：比如在寻找最低公共祖先时，若题目告知输入的节点必存在于树中，则**可不必同时找到两个节点**.

