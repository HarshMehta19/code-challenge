class Solution {
    private final int mod = (int) 1e9 + 7;

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[][] arr = new int[n][0];

        for(int i=0;i<n;i++) {
            arr[i] = new int[]{i, primeFactors(nums.get(i)), nums.get(i)};
        }        

        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int[] e: arr) {
            int i=e[0], f=e[1];
            while(!stack.isEmpty() && arr[stack.peek()][1] < f) {
                stack.pop();
            }
            if(!stack.isEmpty())
                left[i] = stack.peek();
            stack.push(i);
        }

        stack.clear();
        for(int i=n-1;i>=0;i--) {
            int f = arr[i][1];
            while(!stack.isEmpty() && arr[stack.peek()][1] <= f)
                stack.pop();
            
            if(!stack.isEmpty())
                right[i] = stack.peek();

            stack.push(i);
        }

        Arrays.sort(arr, (a, b) -> b[2] - a[2]);

        long ans = 1;
        for(int[] e: arr) {
            int i = e[0], x = e[2];

            int l = left[i], r = right[i];
            long count = (long) (i-l) * (r - i);
            if(count <= k) {
                ans = ans * pow(x, count) % mod;
                k-= count;
            } else {
                ans = ans * pow(x, k) % mod;
                break;
            }
            
        }
        return (int) ans;
    }

    private int primeFactors(int n) {
        int i = 2;
        Set<Integer> ans = new HashSet<>();
        while(i <= n/i){
            while(n % i == 0){
                ans.add(i);
                n /= i;
            }
            i++;
        }

        if(n>1) {
            ans.add(n);
        }

        return ans.size();
    }

    private int pow(long a, long n) {
        long ans = 1;
        for(;n>0; n>>=1) {
            if((n & 1) == 1)
                ans = ans * a % mod;

            a = a * a % mod;
        }

        return (int) ans;
    }
}