class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = 0;
        for (int candy : candies)
            max = Math.max(candy, max);

        int left = 1, right = max, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canProvide(candies, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else
                right = mid-1;
        }

        return ans;
    }

    private boolean canProvide(int[] candies, long k, int count) {
        if (count == 0)
            return true;

        long total = 0;
        for (int candy : candies) {
            total += candy / count;
            if (total >= k) {
                // System.out.println("count: "+ count +", total: " + total);
                return true;
            }
        }
        return false;
    }
}