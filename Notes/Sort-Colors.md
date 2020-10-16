# Sort Color

## Information

- DATE: 2020.10.14
- LINK: [剑指 Offer 67](https://leetcode-cn.com/problems/sort-colors/)
- TAG: `sort` `double-pointer` `array`

## Description

> 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
>
> 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
>
> **注意**:
> 不能使用代码库中的排序函数来解决这道题。
>
> **示例**:
>
> 输入: `[2,0,2,1,1,0]`
> 输出: `[0,0,1,1,2,2]`
>
> **进阶**：
>
> *一个直观的解决方案是使用计数排序的两趟扫描算法。*
> *首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。*
> *你能想出一个仅使用常数空间的一趟扫描算法吗？*

## Answer

```java
class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1, i = 0;
        while( i <= two ){//tow指向的是最后一个探索的点
            if(nums[i] == 0){
                swap(nums, i, zero);// i不应小于zero
                zero++;
                i++;
            }else if(nums[i] == 1){
                i++;
            }else{
                swap(nums, i, two);
                two--;
            }
           
        } 
    }

    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

## Notes

- 一个遍历指针 + 两个标识指针 实现了三分。
- 注意遍历指针应不小于前指针，所以要 `++` ，而后指针始终指向遍历指针未访问过的元素，这有两个影响：1.循环结束条件是 `<=` 2.与后指针交换时，遍历指针不变。