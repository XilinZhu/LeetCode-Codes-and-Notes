# 346. Moving Average from Data Stream

## Information

- DATE: 2020.08.08
- LINK: [LeetCode-Problem346](https://leetcode-cn.com/problems/moving-average-from-data-stream/)
- TAG: `Circular queue`

## Description

- Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

  > `MovingAverage m = new MovingAverage(3);`
  > `m.next(1) = 1`
  > `m.next(10) = (1 + 10) / 2`
  > `m.next(3) = (1 + 10 + 3) / 3`
  > `m.next(5) = (10 + 3 + 5) / 3`

## My Answer

- 利用数组构造循环队列
- 难点：处理满队列和非满队列两种情况

```java
class MovingAverage {
    private int[] array;
    private int tail;
    private boolean isFull;
    private int size;

    public MovingAverage(int size) {
        array = new int[size];
        tail = 0;
        this.size = size;
        isFull = false;
    }
    
    public double next(int val) {
        if (tail/size == 1) isFull = true;
        tail %= size;
        array[tail] = val;      
        int sum = 0;
        tail++;
        if (isFull){
            for (int i = 0; i < size; i++){
                sum += array[i];
            }
            
            return sum*1.0/size;
        }else{
            for (int i = 0; i < tail; i++){
                sum += array[i];
            }
            return sum * 1.0 / tail;
        }  
        
        
    }
}
```

## My Better Answer

- 利用 `count` 来判断队列是否满，同时利用 `Math.min(size, count)` 将两种情况下的计算统一起来 

```java
class MovingAverage {
    private int[] array;
    private int tail = 0, count = 0, size;

    public MovingAverage(int size) {
        array = new int[size];
        this.size = size;
    }
    
    public double next(int val) {
        tail = count++ % size;
        array[tail] = val;
              
        int sum = 0;
        int currLen = Math.min(count, size);

        for (int i = 0; i < currLen; i++){
            sum += array[i];
        }
        return sum * 1.0 / currLen;
        
    }
}
```

## Even Better Answer

- 实现 `sum` 的复用：注意到前面的算法每次都要重新计算一次 `sum`，但通过分析可以知道，每次 `sum` 的值只是加上了一个新的值，同时可能减去了一个旧值。基于此分析，可以实现 `sum` 的复用。
  - 不仅如此，由于当 `count<size` 时，数组未被赋值的元素都保持为初始值 `0` ，可以将队列满与未满的两种情形通过 `windowSum = windowSum - array[tail] + val;` 统一起来。

```java
class MovingAverage {
    private int[] array;
    private int tail = 0, count = 0, windowSum = 0,size;

    public MovingAverage(int size) {
        array = new int[size];
        this.size = size;
    }
    
    public double next(int val) {
        tail = count++ % size;
        
        windowSum = windowSum - array[tail] + val;
        array[tail] = val;   

        int currLen = Math.min(count, size);
        return windowSum * 1.0 / currLen;
    
    }
}
```

## Notes

- 关于多种情形的统一
  - 使用 `Math.max()` `Math.min()`
- 利用数据复用提高效率
  - 如加数重复的求和运算