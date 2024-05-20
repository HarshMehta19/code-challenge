class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        // if(nums.length == 2) return Math.max(nums[0], nums[1]);// ? nums[0] : nums[1];

        int one = 0;
        int two = 0;

        for(int i=0;i<nums.length;i++) {
            int temp = one;
            one = Math.max(nums[i]+two, one);
            two = temp;
        }
        return Math.max(one, two);



    }
}