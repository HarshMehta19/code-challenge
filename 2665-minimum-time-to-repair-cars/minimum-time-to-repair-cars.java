class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 0, high = Long.MAX_VALUE;
        while(low < high) {
            long mid = (low + high) / 2;
            int count = 0;
            for(int rank : ranks) {
                count += Math.sqrt(mid / rank);
            }

            if(count < cars) low = mid + 1;
            else    high = mid;
        }

        return low;
    }
}