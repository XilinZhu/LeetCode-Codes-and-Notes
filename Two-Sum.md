# 1. Two Sum

## Information

- DATE: 2020.08.07
- LINK: [LeetCode-Problem1](https://leetcode-cn.com/problems/two-sum/)
- TAG: `Array` `Hash Map`

## Description

> 给定 `nums = [2, 7, 11, 15]`，`target = 9`
>
> 因为 `nums[0] + nums[1] = 2 + 7 = 9`
> 所以返回 `[0, 1]`

## Answer

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<> ();
        for (int i=0; i < nums.length; i++){
            int completence = target - nums[i];
            if (map.containsKey(completence)){
                return new int[] {map.get(completence), i};
            }else{
                map.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("No two sum solution!");
    }
}
```

## Notes

- 哈希表（`HashMap`）牺牲空间换时间，可以加快查找的速度。
- 泛型（`<>`）是为了解决在数据在装入集合时的类型都被当做Object对待，从而失去本身特有的类型，从集合里读取时，还要强制转换的问题。
  - java是所谓的静态类型语言，意思是在运行前，或者叫编译期间，就能够确定一个对象的类型，这样做的好处是减少了运行时由于类型不对引发的错误。但是强制类型转换是钻了一个空子，在编译期间不会有问题，**而在运行期间，就有可能由于错误的强制类型转换**，导致错误，这个编译器无法检查到。有了泛型，就可以用不着强制类型转换，在编译期间，编译器就能对类型进行检查，杜绝了运行时由于强制类型转换导致的错误。