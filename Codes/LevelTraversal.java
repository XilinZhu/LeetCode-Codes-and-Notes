import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LevelTraversal {
    

    public int[] levelOrder1(TreeNode root) { 
        if (root == null) return new int[0];
        LinkedList<TreeNode> nodeLis = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        nodeLis.add(root);
        while(!nodeLis.isEmpty()){
            TreeNode currRoot = nodeLis.pollFirst();
            ans.add(currRoot.val);
            if(currRoot.left != null) nodeLis.add(currRoot.left);
            if(currRoot.right != null) nodeLis.add(currRoot.right);
        }
        
        int[] ans2 = new int[ans.size()];
        for (int i =0; i < ans.size();i++){
            ans2[i] = ans.get(i);
        }
        return ans2;
        // return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        LinkedList<TreeNode> nodeLis = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> valLis = new ArrayList<>();
        

        if(root == null) return ans;

        nodeLis.add(root);
        int currNodesLeft = 1;

        while(!nodeLis.isEmpty()){
            TreeNode currRoot = nodeLis.pollFirst();
            valLis.add(currRoot.val);
            currNodesLeft--;
            if(currRoot.left != null) nodeLis.add(currRoot.left);
            if(currRoot.right != null) nodeLis.add(currRoot.right);
            if (currNodesLeft == 0){
                currNodesLeft = nodeLis.size();
                ans.add(valLis);
                valLis = new ArrayList<>();   
            }
        }
        
        return ans;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> nodeLis = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> valLis = new ArrayList<>();     

        if(root == null) return ans;

        nodeLis.add(root);
        int currNodesLeft = 1;

        while(!nodeLis.isEmpty()){
            TreeNode currRoot = nodeLis.pollFirst();

            valLis.add(currRoot.val);
            currNodesLeft--;

            if(currRoot.left != null) nodeLis.add(currRoot.left);
            if(currRoot.right != null) nodeLis.add(currRoot.right);

            if (currNodesLeft == 0){
                if(ans.size() % 2 == 1) Collections.reverse(valLis);
                ans.add(valLis);
                // update the status value.  
                valLis = new ArrayList<>(); 
                currNodesLeft = nodeLis.size();
            }
        }
        return ans;
    }
}