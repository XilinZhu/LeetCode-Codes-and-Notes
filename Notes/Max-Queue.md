# O-59 II. 队列的最大值

# Information

- DATE: 2020.09.22
- LINK: [剑指 offer 59-II.](https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/)
- TAG: `Deque` `Queue`

## Description

> 请定义一个队列并实现函数 `max_value` 得到队列里的最大值，要求函数`max_value`、`push_back` 和 `pop_front` 的**均摊**时间复杂度都是O(1)。
>
> 若队列为空，`pop_front` 和 `max_value` 需要返回 -1
>
> **示例** 1：
>
> 输入: 
> `["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]`
> `[[],[1],[2],[],[],[]]`
> 输出: `[null,null,null,2,1,2]`
>
> **示例** 2：
>
> 输入: 
> `["MaxQueue","pop_front","max_value"]`
> `[[],[],[]]`
> 输出: `[null,-1,-1]`
>
> **限制**：
>
> `1 <= push_back,pop_front,max_value的总操作数 <= 10000`
> `1 <= value <= 10^5`

## Answer

```java
class MaxQueue {
    Queue<Integer> lis;
    Deque<Integer> max;
    
    public MaxQueue() {
        lis = new LinkedList<>();
        max = new LinkedList<>();
    }
    
    public int max_value() {
        return lis.isEmpty() ? -1 : max.getFirst();
    }
    
    public void push_back(int value) {
        while(max.size() > 0 && value > max.getLast()){
            max.removeLast();
        }
        lis.add(value);
        max.addLast(value);
    }
    
    public int pop_front() {
        if (lis.isEmpty()) return -1;
        
        if(lis.element().equals(max.getFirst())){ //Integer 不可以直接比较
            max.removeFirst();
        }
        return lis.remove();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
```

## Notes

1. Integer不可以直接比较！

