class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : arr1) {
            String str = num + "";
            int len = str.length();
            for(int i=0;i<len;i++) {
                int curr = Integer.parseInt(str.substring(0, i+1));
                set.add(curr);
            }
        }

        int ans = 0;
        for(int num : arr2) {
            String str = num+"";
            int len = str.length();

            for(int i= ans;i<len;i++) {
                int curr = Integer.parseInt(str.substring(0, i+1));
                if(set.contains(curr)){
                    ans = i+1;
                }
            }

        }
        return ans;
    }
}