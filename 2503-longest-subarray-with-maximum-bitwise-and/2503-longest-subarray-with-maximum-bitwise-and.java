class Solution {
    public int longestSubarray(int[] nums) {
        int result = 0, length = 0, max = 0;
        for(int num : nums) {
            max = Math.max(max, num);
        }

        for(int num : nums){
            if(num == max) {
                result = Math.max(result, ++length);
            } else{
                length = 0;
            }
        }
        return result;
    }
}