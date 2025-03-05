class Solution {
    public long coloredCells(int n) {
        if(n == 1) return 1;
        // long ans = 1;
        // for(int i=2;i<=n;i++){
        //     ans += Math.pow(2, i);
        // }
        return 1l * n * n + 1l * (n-1) * (n-1);
    }
}