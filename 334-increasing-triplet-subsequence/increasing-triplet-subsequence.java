class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num<=a)
                a = num;
            else if(num <= b)
                b = num;
            else
                return true;
        }
        return false;
        // int i=0, j=1;
        // while(i<=j && j<nums.length) {
        //     if(nums[i] < nums[j]) {
        //         if(j+1<nums.length && nums[j] < nums[j+1])
        //             return true;
        //     }
        //     i++;
        //     j++;
        // }
        // return false;
        // int n = nums.length;
        // int i = 0;
        // while(i<n) {
        //     int start = i+1;
        //     while(start < n) {
        //         if(nums[i]<nums[start]) {
        //             int end = start+1;
        //             while(end<nums.length && nums[start]>=nums[end])
        //                 end++;
        //             if(end<n) return true;
        //         }
        //         start++;
        //     }
        //     // i++;
        //     // while(start<nums.length && nums[i]>= nums[start]){
        //     //     start++;
        //     // }
        //     // int end = start+1;
        //     // while(end<nums.length && nums[start]>=nums[end])
        //     //     end++;
        //     // if(start < n && end < n) return true;
        //     i++;
        // }
        // return false;
    }
}