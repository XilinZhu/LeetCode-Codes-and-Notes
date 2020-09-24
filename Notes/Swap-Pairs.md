# Swap Pairs

## Information

- DATE: 2020.09.24
- LINK: [LeetCode-Problem24](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)
- TAG: `LinkedList` `recursion` 

## Description

> 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
>
> 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
>
>  
>
> **示例**:
>
> `给定 1->2->3->4, 你应该返回 2->1->4->3.`

## My Answer: 顺序迭代

```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = new ListNode(-1);
        ListNode p = head, q = head.next;
        ListNode ans = head.next;

        while (p != null){
            //交换次序
            p.next = q.next;  
            q.next = p;
            
            if( p.next == null || p.next.next == null){ //到达尾部，且链表元素个数为奇数或偶数
                break;
            }else{
                tmp = p.next;   //存储下一轮的第一个结点
                p.next = p.next.next;//这一轮的新第一个节点要指向下一轮的旧第二个节点
            }

            p = tmp;
            q = p.next;

        }
        return ans;
    }
}
```

## Better Answer: 递归

```java
class Solution {
    public ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }
}
```

## Notes

- 当迭代因需要附加条件而变得复杂时，考虑递归。