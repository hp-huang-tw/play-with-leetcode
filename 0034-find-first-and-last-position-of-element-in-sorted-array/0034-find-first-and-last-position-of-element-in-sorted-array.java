class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        
        return new int[]{left, right};
    }
    
    private int binarySearch(int[] nums, int target, boolean isLeftBias) {
        int l = 0, r = nums.length - 1;
        
        int index = -1;
        while (l <= r) {
            int mid = (l + r)/2;
            
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                index = mid;
                
                if (isLeftBias) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        
        return index;
    }
}