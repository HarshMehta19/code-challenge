class Solution {
    public int minCapability(int[] nums, int k) {
        int max = 1;
        for(int num : nums)
            max = Math.max(max, num);
        int left = 1, right = max, n = nums.length;
        while (left < right) {
            int mid = (left + right) / 2, take = 0;
            for (int i = 0; i < n; ++i)
                if (nums[i] <= mid) {
                    take += 1;
                    i++;
                }
            if (take >= k)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}