import java.util.LinkedList;
import java.util.List;

public class PathSum {
    LinkedList<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSumRecursion(root, sum);
        return ans;
    }

    private void pathSumRecursion(TreeNode root, int target){
        if (root == null) return;
        target -= root.val;
        path.add(root.val);
        if (target == 0 && root.left == null && root.right == null)       
            ans.add(new LinkedList(path));

        pathSumRecursion(root.left, target);
        pathSumRecursion(root.right, target);
        path.removeLast();
    }
}