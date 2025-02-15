class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;

        for(int curr = 1; curr<=n;curr++) {
            int square = curr * curr;

            if(isPartitioned(square, curr)){
                ans += square;
            }
        }

        return ans;
    }

    private boolean isPartitioned(int square, int target) {
        if(square < target || target < 0)
            return false;

        if(square == target) return true;

        return (isPartitioned(square/10, target-(square%10)) || isPartitioned(square/100, target-(square%100)) || isPartitioned(square/1000, target-(square%1000)));
    }
}