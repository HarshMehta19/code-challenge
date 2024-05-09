class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {

        Arrays.sort(happiness);
        
        long maxCount = 0;
        int operations = 0;
        int length = happiness.length;
        while(operations < k && (length - 1)- operations >=0 ) {
            if(happiness[length - operations - 1] - operations <= 0)
                break;
            maxCount+= happiness[length - operations - 1] - operations;
            operations++;
        }
        return maxCount;
    }
}