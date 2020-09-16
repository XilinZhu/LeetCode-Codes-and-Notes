# Copy Random List

## Information

- DATE: 2020.09.16
- LINK: [剑指 offer 35](https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/)
- TAG: `list` `double pointer` 

## Description

> 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
>
>  
>
> **示例 1**：
>
> ![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e1.png)
>
> `输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]`
> `输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]`
>
> **提示**：
>
> - `-10000 <= Node.val <= 10000`
> - `Node.random` 为空（null）或指向链表中的节点。
> - 节点数目不超过 1000 。

## My Answer

- 先完成单链表的复制，同时建立起从每个原节点到每个复制节点的哈希表。然后，再进行 `random` 的复制。

```java
class Solution {
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
```

- 时间复杂度：$O(2N)$
- 空间复杂度：$O(N)$

## Better Answer

- 将 `random` 的复制也融入到递归中，可以减少一半的节点访问次数。
  - 因为递归会首先将所有的节点复制，所以不必担心 `head.random` 会不存在于哈希表中

```java
class Solution {
    Map<Node, Node> nodes = new HashMap<>(); 

    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node copy = new Node(head.val);
        nodes.put(head, copy);

        copy.next = copyRandomList(head.next);
        copy.random = nodes.get(head.random);

        return copy;
    }
}
```

- 时间复杂度：$O(N)$
- 空间复杂度：$O(N)$

## Notes

- 递归中的状态理解：递归开始向上返回结果前已经完成链表的遍历。