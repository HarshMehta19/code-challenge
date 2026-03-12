class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max_sum = 0;
        int curr_sum = 0;
        for(int i =0; i<k;i++) {
            curr_sum+=nums[i];
            max_sum = curr_sum;
        }

        int left = 0, right = k;
        while(right<nums.length) {
            curr_sum += nums[right++];
            curr_sum -= nums[left++];
            max_sum = Math.max(max_sum, curr_sum);
        }
        System.out.println("max_sum: " + max_sum);
        return (double) max_sum / k;
    }
}