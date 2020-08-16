public class BuildTree {
    
    public TreeNode buildTree(Integer[] items, int rootIndex){
        Integer rootVal = rootIndex < items.length ? items[rootIndex] : null;
        if (rootVal == null) return null;
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(items, rootIndex*2+1);
        root.right = buildTree(items, rootIndex*2+2);
        return root;
    }

    
    // public static void main(String[] args) {
    //     BuildTree bt = new BuildTree();
    //      bt.buildTree([5,4,8,11,null,13,4,7,2,null,null,5,1], 0);
    // }
}