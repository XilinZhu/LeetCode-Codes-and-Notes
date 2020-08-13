import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PathSum {
    List<List<Integer>> ans = new Stack<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        int currSum = 0;
        Stack<Integer> path = new Stack<>();
        
        pathSum(root, sum, path, currSum);
        return ans;
    }

    private void pathSum(TreeNode root, int sum, Stack<Integer> path, int currSum){
        if (root == null) return;
        if (root.left == null && root.right == null){
            if (currSum + root.val == sum){
                path.push(root.val);
                ans.add(List.copyOf(path));
                path.pop();
            } 
            return;
        }


        path.push(root.val);
        currSum += root.val;
        pathSum(root.left, sum, path, currSum);
        pathSum(root.right, sum, path, currSum);
        path.pop();
    }
}