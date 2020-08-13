import java.util.HashMap;
import java.util.Map;

public class ReconsructATree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i =0; i < inorder.length; i++){
            indexMap.put(inorder[i], i);
        }
        // TreeNode root = new TreeNode(preorder[0]);
        return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length, indexMap);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer,Integer> indexMap){
        if (preEnd - preStart == 0) return null;
        
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        if (preEnd - preStart == 1) return root;

        int i = indexMap.get(rootVal) - inStart;

        // TreeNode left = i == 0 ? null : new TreeNode(preorder[preStart+1]);
        // TreeNode right = i >= inEnd-inStart-1 ? null : new TreeNode(preorder[preStart+i+1]);

        root.left = buildTree(preorder, inorder, preStart+1, preStart+i+1, inStart, inStart+i,indexMap);
        root.right = buildTree(preorder, inorder, preStart+i+1, preEnd, inStart+i+1, inEnd,indexMap);;

        return root;
        // buildTree(preorder, inorder, preStart+1, preStart+i+1, inStart, inStart+i,indexMap);
        
        // buildTree(preorder, inorder, preStart+i+1, preEnd, inStart+i+1, inEnd,indexMap);
    }

    public static void main(String[] args) {
        ReconsructATree s = new ReconsructATree();
        int[] preorder = new int[] {1,2,3};
        int[] inorder = new int[] {2,3,1};
        s.buildTree(preorder, inorder);
    }
}