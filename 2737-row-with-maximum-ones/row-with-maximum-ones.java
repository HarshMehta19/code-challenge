class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int ans[] = new int[]{-1, -1};

        for(int i=0;i<mat.length;i++) {
            int countOnes = 0;
            for(int j:mat[i]) {
                countOnes+=j;
            }
            if(countOnes>ans[1]) {
                ans[0] = i;
                ans[1] = countOnes;
            }
        }
        return ans;
    }
}