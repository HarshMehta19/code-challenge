class Solution {
    public int minOperations(int[][] grid, int x) {
        int sum = 0;
         List<Integer> list = new ArrayList<>();
        for(int[]ele : grid) {
            for(int num: ele) {
                if(num % x != grid[0][0] % x)
                    return -1;
                list.add(num);
            }
        }

        Collections.sort(list);
        int median = list.get(list.size() / 2);
        int result = 0;

        for(int num: list) {
            int diff = Math.abs(num - median);
            result+= diff / x;

        }

        return result;
    }
}