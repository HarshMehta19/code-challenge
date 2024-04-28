class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(solve(nums, 0, nums.length - 2),
                        solve(nums, 1, nums.length - 1));
    }

    int solve(int[] nums, int start, int end) {
        int rob1 = 0, rob2 = 0;
        for(int i = start;i<=end;i++) {
            int ans = Math.max(rob2 + nums[i], rob1);
            rob2 = rob1;
            rob1 = ans;
        }
        return rob1;
    }
}