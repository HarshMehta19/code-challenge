class Solution {
    public int maximumSum(int[] nums) {
        int[] sumNum = new int[100];
        int ans = -1;
        for(int num : nums) {
            int tempNum = num;
            int sum = 0;
            while(tempNum != 0 ){
                sum += tempNum % 10;
                tempNum /= 10;
            }
            if(sumNum[sum] != 0)
                ans = Math.max(ans, num + sumNum[sum]);
            
            sumNum[sum] = Math.max(sumNum[sum], num);
        }

        return ans;
    }
}