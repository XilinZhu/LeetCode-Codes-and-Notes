# 206. Reverse Linked List

## Information

- DATE: 2020.08.06
- LINK: [LeetCode-Problem206](https://leetcode-cn.com/problems/reverse-linked-list/)
- TAG: `LinkedList` `recursion` `iteration`
- UPDATE: 2020.10.10

### Description

- Reverse a singly linked list.

  > Input: `1->2->3->4->5->NULL`
  > Output: `5->4->3->2->1->NULL`

### Answer 1: Recursion

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next); //存储了尾节点
    head.next.next = head;
    head.next = null;
    return p;
}
```

- `head.next.next = head;` 从后往前执行，实现了单链表的反向操作，十分优美；
- 单链表中要避免循环链表出现，故 `head.next =null`

### Answer 2: Iteration

```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}
```

- 取名尽量具有指代性
  - `prev` `curr` `nextTemp`
- 十分巧妙地在普遍解法中包含了链表的长度为0 或 1 的特殊情况



