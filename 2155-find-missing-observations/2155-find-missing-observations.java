class Solution {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }

        int diff = (mean * (rolls.length + n)) - sum;
        // int diff = totalSum - sum;
        if(diff<=0 || n*6<diff||((diff/n)==0))
            return new int[] {};
        int result[] = new int[n];

        int fixVal = diff/n, variable = diff % n;
        int i=0;
        while(i<n){
            result[i++] = fixVal + (variable>0?1:0);
            variable--;
        }
        return result;
    }
}