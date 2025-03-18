class Solution {
    public int longestNiceSubarray(int[] nums) {
        int res = 0, n = nums.length, left = 0, right = 0, sum = 0;
        while(right < n) {
            while((sum & nums[right]) != 0)
                sum -= nums[left++];
            sum += nums[right];
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}