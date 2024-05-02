class Solution {
    public int maxProfit(int[] prices) {
        // int maxProfit = 0;
        // int l = 0, j = 1;
        // while(j<prices.length) {
        //     if(prices[l]<prices[j])
        //         maxProfit = Math.max(maxProfit, prices[j] - prices[l]);
        //     else
        //         l = j;
        //     j++;
        // }
        // return maxProfit;

        int minBuy = prices[0];
       int maxSell = 0;
        for (int i = 1; i < prices.length; i++) {
            minBuy = Math.min(prices[i], minBuy);
            maxSell = Math.max(maxSell, prices[i]-minBuy);
        }
        return maxSell;
    }

    
}