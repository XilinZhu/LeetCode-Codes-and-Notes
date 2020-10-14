# O32. Level Order

## Information

- DATE: 2020.08.13
- LINK: [剑指 offer 32](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)
- TAG: `tree` `BFS`

## Level Order I

### Description

> 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
>
> **例如**:
> 给定二叉树: `[3,9,20,null,null,15,7]`,
>
>     	3
>        / \
>        9  20
>          /  \
>         15   7
> 返回：
>
> `[3,9,20,15,7]`

### Answer

- BFS
- `Integer[]` to `int[]` 的两种方法
  - 循环快于 `steam`

```java
class Solution {
    public int[] levelOrder(TreeNode root) { 
        if (root == null) return new int[0];
        LinkedList<TreeNode> lis = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        lis.add(root);
        while(!lis.isEmpty()){
            TreeNode currRoot = lis.pollFirst();
            ans.add(currRoot.val);
            if(currRoot.left != null) lis.add(currRoot.left);
            if(currRoot.right != null) lis.add(currRoot.right);
        }
        
        int[] ans2 = new int[ans.size()];
        for (int i =0; i < ans.size();i++){
            ans2[i] = ans.get(i);
        }
        return ans2;
        // return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

## Level Order II

### Description

> 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
>
> **例如**:
> 给定二叉树: `[3,9,20,null,null,15,7]`,
>
>          3
>         / \
>        9  20
>          /  \
>         15   7
> 返回其层次遍历结果：
>
> `[`
> `[3],`
> `[9,20],`
> `[15,7]`
> `]`

### Answer

- 记录每层应打印的个数：当每层打印完时，队列中已有的节点个数即下一层的待打印节点数。另外可知，第一层的个数为 1。如此可递推，直至所有节点被打印。

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> lis = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        

        if(root == null) return ans;

        lis.add(root);
        int currNum = 1;

        while(!lis.isEmpty()){
            TreeNode currRoot = lis.pollFirst();
            curr.add(currRoot.val);
            currNum--;
            if(currRoot.left != null) lis.add(currRoot.left);
            if(currRoot.right != null) lis.add(currRoot.right);
            if (currNum == 0){
                currNum = lis.size();
                ans.add(curr);
                curr = new ArrayList<>();   
            }
        }
        
        return ans;
    }
}
```

## Level Order III

### Description

> 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
>
> 例如:
> 给定二叉树: `[3,9,20,null,null,15,7]`,
>
>          3
>         / \
>        9  20
>          /  \
>         15   7
> 返回其层次遍历结果：
>
> `[`
> `[3],`
> `[20,9],`
> `[15,7]`
> `]`

## Answer

- 使用 `ans.size()` 来判断当前层数
- 当 `ans.size()` 为奇数时，当前层为奇数层，需要反转；否则，不反转

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> nodeLis = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> valLis = new ArrayList<>();     

        if(root == null) return ans;

        nodeLis.add(root);
        int currNodesLeft = 1;

        while(!nodeLis.isEmpty()){
            TreeNode currRoot = nodeLis.pollFirst();

            valLis.add(currRoot.val);
            currNodesLeft--;

            if(currRoot.left != null) nodeLis.add(currRoot.left);
            if(currRoot.right != null) nodeLis.add(currRoot.right);

            if (currNodesLeft == 0){
                if(ans.size() % 2 == 1) Collections.reverse(valLis);
                ans.add(valLis);
                // update the status value.  
                valLis = new ArrayList<>(); 
                currNodesLeft = nodeLis.size();
            }
        }
        return ans;
    }
}
```

