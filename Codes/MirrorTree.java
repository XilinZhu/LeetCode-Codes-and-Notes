class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}