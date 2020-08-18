public class MergeTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while( l1 != null && l2 != null ){
            if( l1.val <= l2.val ){
                curr.next = l1;
                curr = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                curr = l2;  
                l2 = l2.next; 
            }
        }

        curr.next = ( l1 == null ) ? l2 : l1;
        return head.next;
    }
}

// /**
//  * Recursion
//  */
// public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//     if ( l1 == null ) return l2;
//     if ( l2 == null ) return l1;
//     if( l1.val <= l2.val ){
//         l1.next = mergeTwoLists( l1.next, l2 );
//         return l1;
//     }
//     else{
//         l2.next = mergeTwoLists( l1, l2.next );
//         return l2;
//     } 
// }