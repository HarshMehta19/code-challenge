class Solution {
    public int longestSubarray(int[] nums) {
        int max = -1;
        int i=0, j=0, zeros = 0;
        while(j<nums.length) {
            if(nums[j] == 0)
                zeros++;

            j++;
            
            while(zeros > 1){
                if(nums[i] == 0)
                    zeros--;
                i++;
            }
            max = Math.max(j - i - 1, max);

        }
        return max;
    }
}