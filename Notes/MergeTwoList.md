# O-25. 合并两个排序的链表

## Information

- DATE: 2020.08.18
- LINK: [剑指 offer 25](https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/)
- TAG: `divide-and-conquer` `linked list` `sort`

## Description

> 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
>
> **示例**1：
>
> 输入：`1->2->4, 1->3->4`
> 输出：`1->1->2->3->4->4`
>
> **限制**：
> `0 <= 链表长度 <= 1000`

## My Answer: Recursion

- 使用递归方法，每次比较都可以选出一个小值作为头节点，而它的后续节点由后续递归算法决定.
- 递归的终止条件是某一个输入链表头节点为 `null`.

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if ( l1 == null ) return l2;
        if ( l2 == null ) return l1;
        if( l1.val <= l2.val ){
            l1.next = mergeTwoLists( l1.next, l2 );
            return l1;
        }
        else{
            l2.next = mergeTwoLists( l1, l2.next );
            return l2;
        } 
    }
}
```

## Another Answer: Iteration

- 引入伪头节点用于返回最终的链表.
- 使用一个节点 `curr`，每次循环都为 `curr` 寻找一个后继节点

```java
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
```

