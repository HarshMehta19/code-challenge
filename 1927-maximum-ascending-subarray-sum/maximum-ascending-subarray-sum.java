class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0], currSum = nums[0];

        for(int i=1;i<nums.length;i++) {
            if(nums[i-1]>=nums[i])
            { 
                sum = Math.max(sum, currSum);
                currSum = 0;
            }

            sum = Math.max(sum, currSum);
            currSum += nums[i];
        }
        sum = Math.max(sum, currSum);
        return sum;
    }
}