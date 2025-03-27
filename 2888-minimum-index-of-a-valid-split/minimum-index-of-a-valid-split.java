class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        int size = nums.size();
        for(int i=0;i<size;i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }

        for(int i=0;i<size;i++) {
            int num = nums.get(i);
            if(map.get(num) == 1) continue;
            left.put(num, left.getOrDefault(num, 0) + 1);
            map.put(num, map.get(num) - 1);
            int leftCnt = left.get(num), rightCnt = map.get(num);
            if((leftCnt*2>(i+1)) && (rightCnt*2 > (size-i-1))) return i;
        }

        return -1;


    }
}