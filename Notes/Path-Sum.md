# O34. 二叉树中和为某一值的路径

## Information

- DATE: 2020.08.13
- LINK: [剑指 offer 34](https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)
- TAG: `tree` `backtrace`

## Description

> 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
>
> **示例**:
> 给定如下二叉树，以及目标和 `sum = 22`，
>
>               5
>              / \
>             4   8
>            /   / \
>           11  13  4
>          /  \    / \
>         7    2  5   1
> 返回:
>
> ```
> [
>    [5,4,11,2],
>    [5,8,4,5]
> ]
> ```

## My Answer

- 在 DFS 的过程中，不断更新 `currSum` ，将满足条件的 `Stack<Integer> path` 保存入 `List<List<Integer>> ans` 里.

```java
class Solution {
    List<List<Integer>> ans = new Stack<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        int currSum = 0;
        Stack<Integer> path = new Stack<>();
        
        pathSum(root, sum, path, currSum);
        return ans;
    }

    private void pathSum(TreeNode root, int sum, Stack<Integer> path, int currSum){
        if (root == null) return;
        if (root.left == null && root.right == null){
            if (currSum + root.val == sum){
                path.push(root.val);
                ans.add(List.copyOf(path));
                path.pop();
            } 
            return;
        }


        path.push(root.val);
        currSum += root.val;
        pathSum(root.left, sum, path, currSum);
        pathSum(root.right, sum, path, currSum);
        path.pop();
    }
}
```

## Better Answer

1. 使用构造器完成 `copy ` ：`List.copyOf()` 依然面临效率问题.
   - `LinkList` 的构造器可以以一个集合为输入，故可用来替代 `copy` 
2. `Stack` 主要适合元素为整数的情况： `Stack` 在元素为整数时效率更高，非整数时用 `LinkedList` 为佳.
3. 递归尽量拥有简明的基准条件，哪怕结果是需要多调用一次.

```java
class Solution {
    LinkedList<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSumRecursion(root, sum);
        return ans;
    }

    private void pathSumRecursion(TreeNode root, int target){
        if (root == null) return;
        
        target -= root.val;
        path.addLast(root.val);
        
        if (target == 0 && root.left == null && root.right == null)       
            ans.add(new LinkedList<>(path));

        pathSumRecursion(root.left, target);
        pathSumRecursion(root.right, target);
     
        path.removeLast();
    }
}
```

