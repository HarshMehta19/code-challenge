class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length) return new int[0][0];
        int[][] result = new int[m][n];
        int totalRows = 0, cols = 0, index = 0;
        while(totalRows < m) {
            cols = 0;
            while(cols < n){
                result[totalRows][cols++] = original[index++];
            }
            totalRows++;
        }
        return result;
    }
}