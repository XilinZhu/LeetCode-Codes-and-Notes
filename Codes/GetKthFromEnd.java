import java.util.LinkedList;
import java.util.List;

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode res = head;
        ListNode curr = head;
        while( k > 1 ){
            curr = curr.next;
        }
        while(curr != null){
            curr = curr.next;
            res = res.next;
        }
        return res;
        
    }
}
