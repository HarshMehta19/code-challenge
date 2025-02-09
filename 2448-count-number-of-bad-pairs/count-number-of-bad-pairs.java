class Solution {
    public long countBadPairs(int[] nums) {
        int length = nums.length;
        long totalPairs = (long) length * (length - 1) / 2;

        Map<Integer, Integer> diffMap = new HashMap<>();

        long goodPairCount = 0;

        for(int i=0;i<nums.length;i++) {
            int diff = nums[i] - i;
            goodPairCount += diffMap.getOrDefault(diff, 0);
            diffMap.put(diff, diffMap.getOrDefault(diff, 0) + 1);
        }

        return totalPairs - goodPairCount;
    }
}