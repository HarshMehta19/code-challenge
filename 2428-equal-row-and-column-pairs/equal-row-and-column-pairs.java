class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        int n = grid.length;

        for(int i=0;i<n;i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++) {
                list.add(grid[i][j]);
            }
            map.put(list, map.getOrDefault(list, 0) + 1);
        }

        int count = 0;
        for(int i=0;i<n;i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++) {
                list.add(grid[j][i]);
            }
            if(map.containsKey(list)){
                count+=map.get(list);
            }
        }
        return count;
        
    }
}