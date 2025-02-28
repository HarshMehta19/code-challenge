class Solution {
    int[][] arr = new int[1001][1001];

    public String shortestCommonSupersequence(String str1, String str2) {
        int M = str1.length(), N = str2.length();
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++)
                arr[i][j] = -1;
        }

        int x = M + N - maxi(str1, str2, M, N);
        String ans = "";
        int i = M, j = N;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans = "" + str1.charAt(i - 1) + ans;
                i--;
                j--;
            } else if (arr[i - 1][j] > arr[i][j - 1]) {
                ans = "" + str1.charAt(i - 1) + ans;
                i--;
            } else {
                ans = "" + str2.charAt(j - 1) + ans;
                j--;
            }
        }

        while (i > 0) {
            ans = "" + str1.charAt(i - 1) + ans;
            i--;
        }

        while (j > 0) {
            ans = "" + str2.charAt(j - 1) + ans;
            j--;
        }

        return ans;
    }

    private int maxi(String str1, String str2, int M, int N) {
        if(M == 0 || N == 0)
            return 0;
        
        if(arr[M][N] != -1)
            return arr[M][N];

        if(str1.charAt(M-1) == str2.charAt(N-1)){
            arr[M][N] = 1 + maxi(str1, str2, M - 1, N - 1);
            return arr[M][N];
        }

        return arr[M][N] = Math.max(maxi(str1, str2, M, N - 1), maxi(str1, str2, M - 1, N));
    }

}