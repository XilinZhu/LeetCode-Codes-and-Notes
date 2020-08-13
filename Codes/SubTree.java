public class SubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null && s == null) 
            return true;
        else if (t == null || s == null)
            return false;
        else if (t.val == s.val && isSame(s, t))
            return true;
        else
            return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t){
        if (t == null && s == null) 
            return true;
        else if (t == null || s == null)
            return false;
        else if (t.val == s.val)
            return  isSame(s.left, t.left) && isSame(s.right, t.right);
        else
            return false;
    }


}