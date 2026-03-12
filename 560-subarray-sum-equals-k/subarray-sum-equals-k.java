class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int num : nums) {
            total +=num;

            if(map.containsKey(total - k)) {
                res += map.get(total - k);
            }

            map.put(total, map.getOrDefault(total, 0) + 1);
        }
        return res;
    }
}