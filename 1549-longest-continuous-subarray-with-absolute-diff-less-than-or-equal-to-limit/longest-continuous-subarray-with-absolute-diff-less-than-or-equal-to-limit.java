class Solution {
    public int longestSubarray(int[] nums, int limit) {

        int res = 0;
        int left = 0;

        LinkedList<Integer> min = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();

        for(int i=0;i<nums.length; i++) {
            int n = nums[i];

            while(min.size() > 0 && n < min.getLast()){
                min.removeLast();
            }

            while(max.size() > 0 && n > max.getLast()){
                max.removeLast();
            }

            min.add(n);
            max.add(n);

            while(max.getFirst() - min.getFirst() > limit) {
                if(nums[left] == max.getFirst())
                    max.removeFirst();
                
                if(nums[left] == min.getFirst())
                    min.removeFirst();

                left++;
            }
            int size = i - left + 1;
            res = Math.max(res, size);

        }
        return res;
        // int i=0, j=0;
        // int n = nums.length;
        // int max = -1, min = Integer.MAX_VALUE;
        // int res = -1;
        // while(i<n){
        //     max = -1;
        //     min = Integer.MAX_VALUE;
        //     while(j<n){
        //         max = Math.max(max, nums[j]);
        //         min = Math.min(min, nums[j]);

        //         if(max - min <= limit) {
        //             res = Math.max(res, j - i + 1);
        //         }
        //         j++;
        //     }
        //     i++;
        //     j = i;
        // }
        // return res;
    }
}