class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[2*n - 1];
        boolean[] visited = new boolean[n+1];

        helper(0, visited, ans, n);
        return ans;
    }

    private boolean helper(int index, boolean[] visited, int[] ans, int n) {
        if(index == ans.length) return true;

        if(ans[index] != 0) return helper(index+1, visited, ans, n);
        else {
            for(int i=n;i>=1;i--) {
                if(visited[i]) continue;
                visited[i] = true;
                ans[index] = i;
                if(i == 1) {
                    if(helper(index+1, visited, ans, n)) return true;
                } else if(index + i < ans.length && ans[index + i] == 0) {
                    ans[i+index] = i;
                    // visited[i+index] = true;
                    if(helper(index+1, visited, ans, n)) return true;
                    ans[i+index] = 0;

                }
                ans[index] = 0;
                visited[i] = false;
            }
        }
        return false;
    }
}