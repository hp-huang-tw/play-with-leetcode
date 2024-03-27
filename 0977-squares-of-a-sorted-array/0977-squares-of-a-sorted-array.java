class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        int idx = len - 1;
        
        int[] squares = new int[len];
        
        while (l <= r) {
            int num = 0;
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                num = nums[l];
                l++;
            } else {
                num = nums[r];
                r--;
            }
            
            squares[idx] = num * num;
            idx--;
        }
        
        return squares;
    }
}