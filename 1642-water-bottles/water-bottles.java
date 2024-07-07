class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalBottles = numBottles;
        int remainingBottles = numBottles;
        while(remainingBottles >= numExchange) {
            int bottles = remainingBottles / numExchange;
            totalBottles += bottles;
            remainingBottles = remainingBottles % numExchange;

            remainingBottles += bottles;
        }
        return totalBottles;
    }
}