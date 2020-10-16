# Get Intersection Node

## Information

- DATE: 2020.09.16
- LINK: [剑指 offer 52](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)
- TAG: `list` `double pointer` 

## Description

> 输入两个链表，找出它们的第一个***公共节点***。
>
> 如下面的两个链表**：**
>
> [![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png)](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png)
>
> 在节点 c1 开始相交。
>
> **注意**：
>
> - 如果两个链表没有交点，返回 null.
> - 在返回结果后，两个链表仍须保持原有的结构。
> - 可假定整个链表结构中没有循环。
> - 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

## My Answer

- 思考：若有公共节点，则从公共节点开始的剩余部分长度相同
- 方法：先分别求出长度，使长链表自头节点向前访问，直到剩余长度与短链表相同。然后再一一比较每个节点，若相同，则为第一个公共节点。

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode currA = headA;
        ListNode currB = headB;

        if (lenA > lenB){
            int diff = lenA - lenB;
            while(diff-- > 0){
                currA = currA.next;
            }
        }else{
            int diff = lenB - lenA;
            while(diff-- > 0){
                currB = currB.next;
            }
        }

        while(currA != currB){
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }

    private int getLength(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        
        return count;
    }
}
```

- 时间复杂度：$O(2n+2m)$
- 空间复杂度：$O(1)$

## Better Answer

- 巧妙的双指针方法，同时还包含了两个链表不相交的特殊情况。
  - 若不相交，则两个节点在运动了 $m+n$ 次后同时指向 `null`
- ![](https://i.loli.net/2020/09/16/wPe3EiLMyCBa8nS.png)

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;

        while( node1 != node2 ){
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }

        return node1;
    }
}
```

- 时间复杂度：$O(2n+2m)$
- 空间复杂度：$O(1)$

