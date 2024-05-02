class Solution {
    public int findMaxK(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(num < 0) {
                set.add(num);
            } else {
                if(set.contains(num * -1))
                    max = Math.max(max, num);
            }
        }
        return max == 0 ? -1 : max;

    }
}