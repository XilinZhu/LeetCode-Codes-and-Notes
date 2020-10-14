# O-07. Reconstruct-A-Binary-Tree

## Information

- DATE: 2020.08.12
- LINK: [剑指 Offer-07](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)
- TAG: `tree` `recursion ` `hash map`

## Description

> 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
>
> **例如**，给出
>
> 前序遍历 `preorder = [3,9,20,15,7]`
> 中序遍历 `inorder = [9,3,15,20,7]`
> 返回如下的二叉树：
>
> ```
>     3
>    / \
>   9  20
>     /  \
>    15   7
> ```

## My Answer

- 利用前序遍历和中序遍历的关系，可以将中序遍历以一个根节点为界线分开两部分，左侧为其左子树节点，右侧为其右子树的节点。不仅如此，将同样的划分方法应用于先序遍历序列，左侧第2个元素应为根节点的左儿子，右侧第1个元素为根节点的右儿子.
- 整个算法的核心在于
  1. 寻找根节点于 `inorder` 数组中所在的位置；
     - 遍历 `inorder`，10-13行
  2. 将当前数组分为左子树、根节点、右子树
     - 使用 `Arrays.copyOfRange` ，23、26行
  3. 分别对左子树和右子树进行递归，结束条件为输入的数组长度小于等于 1
- 另外，为了传递根节点信息，定义了一个类字段

```java
class Solution {
    TreeNode currRoot = null;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        
        currRoot = currRoot != null ? currRoot : new TreeNode(preorder[0]);
        if (preorder.length == 1) return currRoot;

        int i;
        for(i = 0; i < inorder.length; i++){
            if (inorder[i] == preorder[0]) break;
        }

        TreeNode left = i == 0 ? null : new TreeNode(preorder[1]);
        TreeNode right = i >= inorder.length-1 ? null : new TreeNode(preorder[i+1]);

        currRoot.left = left;
        currRoot.right = right;
        TreeNode root = currRoot;

        currRoot = left;
        buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
        
        currRoot = right;
        buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
        return root;
    }
}
```

## My Better Answer

- `Arrays.copyOfRange` 效率低，改进方法为：增加一个子函数，其输入除了两个数组外，还有目标元素的索引范围.
  - `private void buildTree(TreeNode r, int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd)`
- 不使用类字段，而是将当前根节点信息作为一个输入进行传递
  - 同上
  - 这样的处理依然不够直接，不是递归规则的直接反应。

```java
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        buildTree(root, preorder, inorder, 0, preorder.length, 0, inorder.length);
        return root;
    }

    private void buildTree(TreeNode r, int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if (preEnd - preStart <= 1) return;

        int i;
        for(i = 0; i+inStart < inEnd; i++){
            if (inorder[i+inStart] == preorder[preStart]) break;
        }

        TreeNode left = i == 0 ? null : new TreeNode(preorder[preStart+1]);
        TreeNode right = i >= inEnd-inStart-1 ? null : new TreeNode(preorder[preStart+i+1]);

        r.left = left;
        r.right = right;

        buildTree(left, preorder, inorder, preStart+1, preStart + i+1, inStart, inStart + i);
        
        buildTree(right, preorder, inorder, preStart + i+1, preEnd,inStart + i+1, inEnd);
    }
}
```

## Even Better Answer

- 考虑到数组中无重复元素，为了加快查找的速度，使用哈希表.

  - ```java
    Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i =0; i < inorder.length; i++){
            indexMap.put(inorder[i], i);
        }
    ```

- 调整函数的输入输出方式，直接地实现递归逻辑

  - ```java
    if (preEnd - preStart == 0) return null;
    ...
    if (preEnd - preStart == 1) return root;
    ...
    root.left = buildTree(preorder, inorder, preStart+1, preStart+i+1, inStart, inStart+i, indexMap);
    root.right = buildTree(preorder, inorder, preStart+i+1, preEnd, inStart+i+1, inEnd, indexMap);
    ```

```java
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i =0; i < inorder.length; i++){
            indexMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length, indexMap);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer,Integer> indexMap){
        if (preEnd - preStart == 0) return null;
        
        int rootVal = preorder[preStart]; //利用先序遍历确定根节点
        TreeNode root = new TreeNode(rootVal);

        if (preEnd - preStart == 1) return root;

        int leftLen = indexMap.get(rootVal) - inStart; // i is the distance from inStart to index of rootVal, and is also the length of left child-tree.利用中序遍历将节点分为左右子树两组

        root.left = buildTree(preorder, inorder, preStart+1, preStart+1+leftLen, inStart, inStart+leftLen, indexMap);// 左子树的长度为 i， 故 preStart+1+i
        root.right = buildTree(preorder, inorder, preStart+1+leftLen, preEnd, inStart+leftLen+1, inEnd, indexMap);

        return root;
    }
}
```

## Notes

1. **`Arrays.copyOfRange()`的效率低**：尽量通过传递元素索引范围的方式实现数组切片，而不是 `Arrays.copyOfRange()` ；
2. **递归算法要直接**：尽量直接地实现递归逻辑，不要绕弯（如借助外部变量）；
3. **非重复元素的比较、查找用哈希表**.

