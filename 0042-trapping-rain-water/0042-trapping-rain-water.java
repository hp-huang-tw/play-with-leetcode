class Solution {
    
    // TC: O(n). SC: O(1)
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        
        int l = 0, r = n -1;
        int maxLeft = height[l], maxRight = height[r];
        int res = 0;
        
        while (l < r) {
            int trapped = 0;
            if (maxLeft < maxRight) { // shift l
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                res += maxLeft - height[l];
                
                
            } else { // shift r
                r--;
                maxRight = Math.max(maxRight, height[r]);
                res += maxRight - height[r];
            }
        }
        
        return res;
    }
}