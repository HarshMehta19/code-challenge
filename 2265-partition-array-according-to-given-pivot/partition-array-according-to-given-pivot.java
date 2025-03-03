class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int j=0;
        int[] ans = new int[nums.length];
        final int length = nums.length;
        for(int i=0;i<length;i++) {
            if(nums[i]>=pivot)
                continue;
            ans[j++] = nums[i];
        }

        for(int i=0;i<length;i++) {
            if(nums[i]==pivot)
                ans[j++] = nums[i];
        }

        for(int i=0;i<length;i++) {
            if(nums[i]>pivot)
                ans[j++] = nums[i];
        }

        return ans;
    }
}