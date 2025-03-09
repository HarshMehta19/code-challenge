class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0, n = colors.length;
        int left = 0;
        for(int right = 1; right<n+k-1; right++) {
            if(colors[right % n] == colors[(right - 1) % n]){
                left = right;
            }

            if(right - left + 1 > k)
            {
                left++;
            }
            if(right - left + 1 == k)
                res++;
        }
        return res;
        // for (int i = 1; i < n; i++) {
        //     int count = 1, prev = colors[i], pos = i + 1;

        //     while (count < k) {
        //         if (pos >= n) {
        //             pos -= n;
        //         }
        //         if (prev == colors[pos])
        //             break;
        //         prev = colors[pos];
        //         count++;
        //         if (count == k)
        //             res++;
        //         pos++;
        //     }

        // }

        // return res;

    }
}