class Solution {
    public int minOperations(int[][] grid, int x) {
        int index = 0;
        int[] arr = new int[grid.length * grid[0].length];

        for(int[]ele : grid) {
            for(int num: ele) {
                if(num % x != grid[0][0] % x)
                    return -1;
                arr[index++] = num;
            }
        }

        Arrays.sort(arr);
        int median = arr[arr.length / 2];
        int result = 0;

        for(int num: arr) {
            int diff = Math.abs(num - median);
            result+= diff / x;
        }

        return result;
    }
}