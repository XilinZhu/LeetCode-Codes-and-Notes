import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class KthLargestOfSearchTree {
    int k;
    int res

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