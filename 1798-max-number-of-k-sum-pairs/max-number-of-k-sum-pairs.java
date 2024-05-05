class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int index = 0;
        for(int num: nums) {
            if(num<k) nums[index++] = num;
        }

        Arrays.sort(nums, 0, index);
        int left = 0, right = index - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == k) {
                count++;
                left++;
                right--;
            } else if(sum <k) left++;
            else right --;
        }
        return count;

        // int l = 0, r = n - 1;
        // int count = 0;
        // Arrays.sort(nums);
        // while(l<r) {
        //     int combination = nums[l] + nums[r];
        //     if(combination == k) {
        //         count++;
        //         l++;
        //         r--;
        //     } else if(combination<k) {
        //         l++;
        //     } else {
        //         r--;
        //     }
        // }
        // return count;
        // int n = nums.length;
        // int count = 0;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0;i<n;i++) {
        //     int difference = k - nums[i];
        //     if(map.containsKey(difference)) {
        //         count++;
        //         if(map.get(difference) == 1){
        //             map.remove(difference);
        //         } else {
        //             map.put(difference, map.get(difference) - 1);
        //         }
        //     } else {
        //         map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        //     }
        // }

        // return count;
    }
}