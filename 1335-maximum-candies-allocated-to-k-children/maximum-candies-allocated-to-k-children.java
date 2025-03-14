class Solution {
    public int maximumCandies(int[] candies, long k) {
       long sum = 0;  // Use long to prevent integer overflow
        for (int candy : candies) {
            sum += candy;
        }

        if (sum < k) return 0;  // If total candies are less than kids, return 0

        long low = 1, high = sum / k; // Use long for high
        int ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2; // Use long mid to avoid overflow
            long count = 0;

            for (int candy : candies) {
                count += candy / mid;
            }

            if (count >= k) {
                ans = (int) mid;  // Store the maximum candies per child
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}