import java.util.HashMap;

public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length-1);
    }

    private boolean verifyPostorder(int [] postorder, int left, int right){
        if (left == right) return true;
        int bound = right;
        while(bound > left && postorder[bound] >= postorder[right]){
            bound--;
        }
        if(bound == left) return true;
        for(int i = left; i < bound; i++){
            if(postorder[i] > postorder[right]){
                return false;
            }
        }
        if(!verifyPostorder(postorder, left, bound)) return false;
        if(!verifyPostorder(postorder, bound+1, right)) return false;

        return true;
    }

    public static void main(String[] args) {
        VerifyPostorder s = new VerifyPostorder();
        int[] postorder = {1,2,5,10,6,9,4,3};
        s.verifyPostorder(postorder);
    }
}
