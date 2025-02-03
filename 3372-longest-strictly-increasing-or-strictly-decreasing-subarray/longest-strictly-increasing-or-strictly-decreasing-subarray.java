class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length == 0) return 0;
        int ans=1,res = 1, trend = 2; // 0- decreasing, 1 - increasing, 2 - unknown

        for(int i=1;i<nums.length;i++) {
            if(nums[i-1] < nums[i]) {
                res = trend == 1 ? res+1 : 2;
                trend = 1;
            } else if(nums[i-1] > nums[i]) {
                res = trend == 0 ? res + 1: 2;
                trend = 0;
            } else {
                res = 1;
                trend = 2;
            }
            ans = Math.max(ans, res);
        }
        return ans;
    }
}