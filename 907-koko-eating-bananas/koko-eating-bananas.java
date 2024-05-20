class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for(int pile : piles)
            right = Math.max(right, pile);
        int left = 1;
        while(left<= right) {
            int mid = left + (right - left) / 2;
            long totalHours = totalHours(piles, mid);
            if(totalHours <= h) {
                right = mid - 1;
            } else {
                left = mid +1;
            }
        }
        return left;
    }

    long totalHours(int[] piles, int h) {
        long totalHours = 0;
        for(int i=0;i<piles.length;i++) {
            totalHours += (piles[i] + h - 1) / h;
        }
        return totalHours;
    }
}