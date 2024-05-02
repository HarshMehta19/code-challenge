class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0, j = 1;
        while(j<prices.length) {
            if(prices[l]<prices[j])
                maxProfit = Math.max(maxProfit, prices[j] - prices[l]);
            else
                l = j;
            j++;
        }
        return maxProfit;
    }

    
}