

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

