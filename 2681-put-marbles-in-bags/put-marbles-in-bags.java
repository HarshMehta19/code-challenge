class Solution {
    public long putMarbles(int[] weights, int k) {
        long b[] = new long[weights.length - 1], res = 0;

        for(int i=0;i<b.length;i++)
            b[i] = weights[i] + weights[i + 1];

        Arrays.sort(b);

        for(int i=0;i<k-1;i++) {
            res += b[weights.length - 2 - i] - b[i];
        }

        return res;
    }
}