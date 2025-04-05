class Solution {
    public int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    private int backtrack(int[] nums, int i, int cur) {
        if(i == nums.length) return cur;

        int with = backtrack(nums, i + 1, cur ^ nums[i]);
        int without = backtrack(nums, i + 1, cur);

        return with + without;
    }
}