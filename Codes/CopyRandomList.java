import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    Map<Node, Node> nodes = new HashMap<>(); 

    public Node copyRandomList(Node head) {
        Node copyHead = copyList(head);

        Node curr = head;
        Node copyCurr = copyHead;

        while(curr != null){
            copyCurr.random = nodes.get(curr.random);
            copyCurr = copyCurr.next;
            curr = curr.next;
        }
        return copyHead;
    }

    private Node copyList(Node head){
        if(head == null) return null;

        Node copy = new Node(head.val);
        nodes.put(head, copy);
        copy.next = copyRandomList(head.next);

        return copy;
    }
}
