class Solution {
    
    // Brute force: O(n)
    // Binary Searh: 
    // OC: O(log(n)), TC: O(1)
    public int findMin(int[] nums) {
        int l = 0, r = nums.length -1;
        int min = nums[l];
                   
            
        while (l <= r) {
            if (nums[l] < nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }
            int mid = (l + r)/2;
            min = Math.min(min, nums[mid]);
            
            if (nums[l] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return min;
    }
}