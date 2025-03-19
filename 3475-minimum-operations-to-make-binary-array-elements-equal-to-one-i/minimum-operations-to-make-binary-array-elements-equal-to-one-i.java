class Solution {
    public int minOperations(int[] nums) {
        int left = 0, right = 2, ans = 0;

        while(right < nums.length) {
            if(nums[left] == 0) {
                ans++;
                nums[left] = 1 - nums[left];
                nums[left + 1] = 1 - nums[left + 1];
                nums[left + 2] = 1 - nums[left + 2];
            }

            left++;
            right++;
        }

        if(nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0) return -1;

        return ans;
    }
}