class Solution {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int maxWater = -1;
        while(start < end) {
            int minHeight = Math.min(height[start], height[end]);
            int distance = end - start;
            maxWater = Math.max(maxWater, distance * minHeight);
            while(start<end && height[start]<=minHeight) start++;
            while(start<end && height[end]<=minHeight) end--;
        }

        return maxWater;
        
    }
}