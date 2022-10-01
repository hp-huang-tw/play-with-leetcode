class Solution {
    public int mySqrt(int x) {
        if (x<=1) return x;   
        
        // root may be in the range of 1 to x-1
        int left=1, right=x-1, mid=0;
        
        while (left <= right) {
            mid = left + (right-left)/2;
            if (mid == x/mid) {
                return mid;
            } else if (mid < x/mid) {
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        
        return right;
    }
}