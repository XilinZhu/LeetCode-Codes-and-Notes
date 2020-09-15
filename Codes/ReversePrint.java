import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> ans = new Stack<>();
        ListNode curr = head;
        while( curr != null ){
            ans.push(curr.val);
            curr = curr.next;
        }

        int len = ans.size();
        int[] ansArray = new int[len];
        for(int i = 0; i < ansArray.length; i++){
            ansArray[i] = ans.pop();
        }
        return ansArray;
    }
}
