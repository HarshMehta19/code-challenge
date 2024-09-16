class Solution {
    public int findMinDifference(List<String> timePoints) {
        int res = Integer.MAX_VALUE;
        int n = timePoints.size();
        int[] c = new int[n];

        for(int i=0;i<n;i++) {
            String s = timePoints.get(i);
            c[i] = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
        }
        Arrays.sort(c);
        for(int i = 1;i<n;i++) {
            res = Math.min(res, c[i] - c[i-1]);
        }
        res = Math.min(res, c[0] + (24*60 - c[n-1]));
        return res;
    }
}