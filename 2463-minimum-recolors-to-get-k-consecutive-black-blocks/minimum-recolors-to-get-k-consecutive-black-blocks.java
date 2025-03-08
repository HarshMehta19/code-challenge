class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length(), ans = Integer.MAX_VALUE, flips = 0, count =0, i=0;

        for(int j=0;j<n;j++) {
            if(blocks.charAt(j) == 'W') {
                flips++;
                count++;
            } else if(blocks.charAt(j) == 'B') {
                count++;
            }
            if(count == k) {
                ans = Math.min(ans, flips);
                if(blocks.charAt(i) == 'W') {
                    flips--;
                    count--;
                } else
                    count--;

                i++;
            }
        }
        return ans;
    }
}