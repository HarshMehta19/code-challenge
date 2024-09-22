class Solution {
    public int findKthNumber(int n, int k) {
        int prefix = 1;
        k-=1;

        while(k>0){
            // System.out.println("--------------");
            int count = countWithPrefix(prefix, n);
            // System.out.println("count: "+ count);
            if(k >= count){
                prefix++;
                k-= count;
            } else {
                prefix*=10;
                k--;
            }
        }
        return prefix;
    }

    private int countWithPrefix(int prefix, int n) {
        long first = prefix, next = prefix + 1;
        int totalCount = 0;
        while(first<=n) {
            // System.out.println("first: "+ first);
            // System.out.println("next: "+ next);
            totalCount += Math.min(n+1, next) - first;
            first *= 10;
            next *= 10;
        }
        return totalCount;
    }
}