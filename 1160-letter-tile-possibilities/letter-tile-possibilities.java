class Solution {
    int ans = 0;

    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        helper(arr, new boolean[arr.length]);
        return ans - 1;
    }

    private void helper(char[] arr, boolean[] visited) {
        // if(index == arr.length) return 0;
        ans++;
        for (int index = 0; index < arr.length; index++) {
            if (permutedBefore(index, arr, visited)) // duplicate removal
                continue;
            visited[index] = true;
            helper(arr, visited);
            visited[index] = false;

        }
    }

    private boolean permutedBefore(int index, char[] arr, boolean[] visited) {
        return (visited[index] || (index > 0 && arr[index] == arr[index - 1] && !visited[index - 1]));
    }
}