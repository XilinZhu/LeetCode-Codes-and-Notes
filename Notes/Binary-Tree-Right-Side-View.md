# 199. Binary Tree Right Side View

## Information

- DATE: 2020.08.12
- LINK: [LeetCode-Problem199](https://leetcode-cn.com/problems/binary-tree-right-side-view/)
- TAG: `Tree` `traverse`

## Description

> Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
>
> **Example**:
>
> `Input: [1,2,3,null,5,null,4]`
> `Output: [1, 3, 4]`
> Explanation:
>
> ```
>       1            <---
>   /   \
> 2     3         <---
>   \     \
>     5     4       <---
> ```

## Answer

- 使用“中右左”的节点处理顺序
- 难点：一方面，要保证搜索进行到最深处，另一方面，要确保左节点的处理不会覆盖已处理的右节点
- 解决：添加一个记录当前深度的变量，每次先处理右节点（==此时深度一定小于列表长度==），而左节点的处理只有在 `深度 >= 列表长度` 时才执行（这意味着它是一个比已遍历的所有右节点更深的节点）

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
    List<Integer> ans = new ArrayList<>();
    int currDepth = 0;

    public List<Integer> rightSideView(TreeNode root) {
        getRightSideView(root);
        return ans;
    }
 
    private void getRightSideView(TreeNode t){
        if(t == null) return;
        if(currDepth >= ans.size()) ans.add(t.val);

        currDepth++;
        getRightSideView(t.right);
        getRightSideView(t.left);
        currDepth--;   
    }
}
```

