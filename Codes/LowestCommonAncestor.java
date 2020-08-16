
public class LowestCommonAncestor {
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