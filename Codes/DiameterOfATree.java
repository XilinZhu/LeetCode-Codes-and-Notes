
public class DiameterOfATree {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root); 
        return maxDiameter;
    }

    private int getDepth(TreeNode t){
        if (t == null) return 0;
        int lDepth = getDepth(t.left);
        int rDepth = getDepth(t.right);
        maxDiameter = Math.max( lDepth + rDepth, maxDiameter);
        return Math.max(lDepth, rDepth) + 1;
    }
}