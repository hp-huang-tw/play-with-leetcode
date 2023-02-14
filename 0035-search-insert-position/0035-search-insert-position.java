class Solution {
    /*  
        0.    3
        1 3 5 6 ,target = 5
        l ^   r
          
        1 3 5 6 ,target = 2
        l ^   r
        
        l   
        r                   return l + 1
        
        1 3 5 6  target = 7
        l ^.  r 
            l r
            ^
              l
              r
              ^
        
        1 3 5 6  target = 0
        l ^.  r
        l
        r
    */
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;    
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        
        return (target > nums[l]) ? l + 1 : l;
    }
}