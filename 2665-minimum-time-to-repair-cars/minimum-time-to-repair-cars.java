class Solution {
    public long repairCars(int[] ranks, int cars) {
        // int minRank = ranks[0];
        // for (int rank : ranks) {
        //     minRank = Math.min(minRank, rank);
        // }

        long low = 1, high = 1L * ranks[0] * cars * cars;
        while (low < high) {
            long mid = (low + high) / 2;
            if(isValid(mid, ranks, cars)) {
                high = mid;
            } else
                low = mid + 1;
        }

        return low;
    }

    private boolean isValid(long mid, int[] ranks, int cars) {

        int count = 0;
        for (int rank : ranks) {
            count += Math.sqrt(mid / rank);
            if (count >= cars)
                return true;
        }

        return false;
    }
}