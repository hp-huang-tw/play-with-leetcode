class Solution {
    /*
    [0,0,1,1,1,2,2,3,3,4]
     L   R                  nums[r]>nums[l] swap(l+1, r), l++
     0,1,0,1,1,2,2,3,3 4    
       L       R
         2 1 1 0 2 3 3 4
           L       R
           3 1 0 2 1 3 4
             L         R
             4 0 2 1 3 1
    [0,1,2,3,4] return l+1 =5        
     
    */
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 1;
        
        while (r < nums.length) {   // [0,0,1], [0,1], [0,0]
            if (nums[r] > nums[l]) {
                nums[l + 1] = nums[r];
                l++;
                
            } else {
                r++;
            }
        }
        return l + 1;
    }
}