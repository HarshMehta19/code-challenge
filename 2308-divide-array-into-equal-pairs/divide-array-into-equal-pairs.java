class Solution {
    public boolean divideArray(int[] nums) {
        int pairs = nums.length / 2, count = 0;
        int[] freq = new int[501];
        for(int num : nums) {
            freq[num]++;
        }

        for(int i=1;i<501;i++) {
            if(freq[i] == 0) continue;

            if(freq[i] % 2 == 1) return false;

            count += freq[i] / 2;
        }

        return count == pairs;


    }
}