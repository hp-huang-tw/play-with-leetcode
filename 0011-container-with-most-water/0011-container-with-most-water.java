class Solution {
    // TC: O(n)
    public int maxArea(int[] height) {
        int l = 0, r = height.length -1;
        int area = 0;
        
        while (l < r) {
            int width = r - l;
            int mHeight = Math.min(height[l], height[r]);
            area = Math.max(area, width*mHeight);
            
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        
        return area;
    }
}