import jdk.nashorn.api.tree.Tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode buildTree(Integer[] items, int rootIndex){
        Integer rootVal = rootIndex < items.length ? item[rootIndex] : null;
        if (rootVal == null) return null;
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(items, rootIndex*2+1);
        root.right = buildTree(items, rootIndex*2+2);
        return root;
    }

}