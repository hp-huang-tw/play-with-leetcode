class Solution {
    public int findPeakElement(int[] nums) {
        // return binarySearchRecursoin(nums, 0, nums.length - 1);
        return binarySearchIterative(nums);
    }
    
    private int binarySearchIterative(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
                
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
    
    private int binarySearchRecursoin(int[] nums, int l, int r) {
        if (l == r) 
            return l;
        
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return binarySearchRecursoin(nums, l, mid);
        }
        return binarySearchRecursoin(nums, mid + 1, r);
    }
    
    private int linearScan(int[] nums) {
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        
        return nums.length -1;
    }
}