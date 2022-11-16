class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        
        int l = 0, r = n -1;
        int maxLeft = height[l], maxRight = height[r];
        int sum = 0;
        
        while (l < r) {
            int trapped = 0;
            if (maxLeft < maxRight) { // shift l
                l++;
                trapped = Math.min(maxLeft, maxRight) - height[l];
                maxLeft = Math.max(maxLeft, height[l]);
                
            } else { // shift r
                r--;
                trapped = Math.min(maxLeft, maxRight) - height[r];
                maxRight = Math.max(maxRight, height[r]);
            }
            
            if (trapped > 0) {
                sum += trapped;
            }
        }
        
        return sum;
    }
}