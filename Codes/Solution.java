import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.canPartition(new int[]{1,2,3,4,5,6,7});
    }

    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);

        int total = 0;
        for(int num : nums){
            total += num;
        }
        if (total % 2 != 0) return false;

        int index =0;
        return myPartition(nums, index, total/2);
    }

    public boolean myPartition(int nums[], int index, int target){
        if( index == nums.length) return false;
        if (nums[index] < target){
            return myPartition(nums, index+1, target-nums[index]);
        }
        else if(nums[index] > target){
            return myPartition(nums, index+1, target);
        }
        else return true;
    }
}