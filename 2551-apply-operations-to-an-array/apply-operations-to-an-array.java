class Solution {
    public int[] applyOperations(int[] nums) {
        final int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            if (nums[i] == 0)
                continue;

            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
                i++;
            }
        }

        int j = 0;
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            if (nums[i] != 0)
                ans[j++] = nums[i];
        }
        return ans;
    }
}