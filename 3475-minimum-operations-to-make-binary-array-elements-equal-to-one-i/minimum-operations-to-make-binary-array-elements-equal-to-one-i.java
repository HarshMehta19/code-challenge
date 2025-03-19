class Solution {
    public int minOperations(int[] nums) {
        int left = 0, right = 2, ans = 0;

        while(right < nums.length) {
            if(nums[left] == 0) {
                ans++;
                for(int i = left;i<left+3;i++) {
                    nums[i] = 1 - nums[i];
                }
            }

            left++;
            right++;
        }

        for(int num : nums) {
            if(num == 0) return -1;
        }

        return ans;
    }
}