class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ball = new HashMap<>();
        Map<Integer, Integer> color = new HashMap<>();

        int len = queries.length, unique = 0;
        int[] ans = new int[len];
        for(int index = 0; index<len;index++) {
            int pos = queries[index][0], col = queries[index][1];
            if(ball.containsKey(pos)) {
                int count = color.get(ball.get(pos)) - 1;

                if(count == 0) {
                    color.remove(ball.get(pos));
                    unique--;
                } else {
                    color.put(ball.get(pos), count);
                }
            }

            ball.put(pos, col);
            int count = color.getOrDefault(col, 0) + 1;
            color.put(col, count);
            if(count == 1) unique++;
            ans[index] = unique;
        }

        return ans;
    }
}