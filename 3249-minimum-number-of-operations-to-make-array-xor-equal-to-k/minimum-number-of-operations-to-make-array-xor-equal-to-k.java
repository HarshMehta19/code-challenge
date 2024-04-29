class Solution {
    public int minOperations(int[] nums, int k) {
        for(int num : nums) {
            k = k^num;
            // System.out.println("K is: " + k);
        }
        return updatedK(k);
    }

    int updatedK(int k) {
        int count = 0;
        while(k>0) {
            if((k & 1) == 1)
                count ++;
            k = k>>1;
            System.out.println("K is: " + k);
        }
        return count;
    }
}