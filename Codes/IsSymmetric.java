import java.util.Deque;
import java.util.LinkedList;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> lis = new LinkedList<>();
        TreeNode left;
        TreeNode right;
        lis.addLast(root);
        lis.addLast(root);
        while(!lis.isEmpty()){
            left = lis.pollFirst();
            right = lis.pollFirst();
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            
            lis.addLast(left.left);
            lis.addLast(right.right);
            lis.addLast(left.right);
            lis.addLast(right.left);
        }
        return true;
    }
}