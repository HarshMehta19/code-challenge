class Solution {
    public int numOfSubarrays(int[] arr) {
        final long MOD = 1000000007;
        long ans = 0;
        long odd = 0, even = 0;
        for(int ele: arr) {
            if(ele%2==0) even++;
            else {
                long temp = even;
                even = odd;
                odd = temp;
                odd++;
            }
            ans+=odd;
        }

        return (int)(ans % MOD);
    }
}