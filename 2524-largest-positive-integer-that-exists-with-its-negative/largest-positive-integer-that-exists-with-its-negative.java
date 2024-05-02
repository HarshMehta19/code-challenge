class Solution {
    public int findMaxK(int[] nums) {
        int max = -1;
        int[] arr = new int[1001];
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) {
            int index = n > 0 ? n : -n;
            if(arr[index] != n) {
                arr[index] += n;
            }

            if(arr[index] == 0) {
                max = Math.max(max, n);
            }
            // if(num < 0) {
            //     set.add(num);
            // } else {
            //     if(set.contains(-num))
            //         max = Math.max(max, num);
            // }
        }
        return max;

    }
}