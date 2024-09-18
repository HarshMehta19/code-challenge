class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";

        String[] str = new String[nums.length];
        for(int i=0;i<nums.length;i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (a, b) -> (b+a).compareTo(a + b));
        return str[0].equals("0") ? "0": String.join("", str);
    }
}