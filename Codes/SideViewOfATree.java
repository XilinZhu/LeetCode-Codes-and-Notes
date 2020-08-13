import java.util.ArrayList;
import java.util.List;


public class SideViewOfATree {
    List<Integer> ans = new ArrayList<>();
    int currDepth = 0;

    public List<Integer> rightSideView(TreeNode root) {
        getRightSideView(root);
        return ans;
    }
 
    private void getRightSideView(TreeNode t){
        if (t == null) return;
        if(currDepth >= ans.size()) ans.add(t.val);

        currDepth++;
        getRightSideView(t.right);
        getRightSideView(t.left);
        currDepth--;   
    }
}