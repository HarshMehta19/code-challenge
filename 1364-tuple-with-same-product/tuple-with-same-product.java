class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int len = nums.length;

        for(int i=0;i<len;i++) {
            for(int j=i+1;j<len;j++) {
                if(nums[i] != nums[j]) {
                    int prod = nums[i] * nums[j];
                    count.put(prod, count.getOrDefault(prod, 0) + 1);
                }
            }
        }

        int result = 0;
        for(Integer product : count.keySet()) {
            if(count.get(product) > 1) {
                int occur = count.get(product);
                result += occur * (occur-1) / 2;
            }
        }

        return result * 8;
    }
}