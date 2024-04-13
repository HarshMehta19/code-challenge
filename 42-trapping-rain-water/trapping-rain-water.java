class Solution {
    public int trap(int[] height) {
        int count = 0;
        int l =0;
        int r = height.length - 1;
        int maxL = height[l], maxR = height[r];
        while(l < r) {
            if(height[l] < height[r]) {
                l++;
                maxL = Math.max(maxL, height[l]);
                count += maxL - height[l];
            } else {
                r--;
                maxR = Math.max(maxR, height[r]);
                count+= maxR - height[r];
            }
        }
        return count;
    }
}