```java
public class Solution {
    public void sort(int[] nums){
        if (nums == null || nums.length == 0) return;
        quickSort(nums, 0, nums.legnth-1)
    }

    private void quickSort(int[] nums, int start ,int end ) {
        // 递归终止条件
        if(start >= end) return;
        
        // 三值中位数确定 pivot
        int pivot = median3(nums, start, end);

        // partition
        while (){
            while (nums[++left] < pivot){}
            while (nums[--right] > pivot){} 
            if (left < right) {
                swap(nums, left, right);
            }else{
                break;
            }
        }
        swap(nums, i, right - 1);

        quickSort(nums[], start, right);
        quickSort(nums[], left, end);
    }
    
    private int median3(int[nums], int left, int right){
        int mid = (left + right) >> 1;
        
        if(nums[left] > nums[mid]){
            swap(nums, left, mid);
        }
        if(nums[left] > nums[right]){
            swap(nums, left, right);
        }
        if(nums[mid] > nums[right]){
            swap(nums, mid , right);
        }
        
        swap(nums, mid, right - 1); //将 pivot 移动到最右边，又因为 nums[right] > pivot, 所以移动到 (right-1)
        return nums[right-1];
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

