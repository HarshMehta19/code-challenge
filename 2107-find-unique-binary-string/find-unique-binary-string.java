class Solution {
    String ans;
    public String findDifferentBinaryString(String[] nums) {
        if(nums.length == 0 ) return "";
        int n = nums[0].length();
        helper(new StringBuilder(), nums, n);
        return ans;

    }

    private void helper(StringBuilder sb, String[] nums, int length) {
        if(sb.length() == length) {
            if(!Arrays.asList(nums).contains(sb.toString())){
                ans = sb.toString();
            }
            return;
        }
        int charLen = sb.length();
        for(char c='0';c<='1';c++) {
            sb.append(c);
            helper(sb, nums, length);
            sb.deleteCharAt(charLen);
        }
    }
}