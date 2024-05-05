class Solution {
    public void moveZeroes(int[] nums) {
        int indexOfNonZero = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != 0) {
                nums[indexOfNonZero++] = nums[i];
            }
        }

        while(indexOfNonZero < nums.length) {
            nums[indexOfNonZero++] = 0;
        }
    }
}