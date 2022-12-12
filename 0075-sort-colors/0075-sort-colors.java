class Solution {
    
    /*
        Dutch National Flag problem solution.
    */
    // 0: read
    // 1: white
    // 2: blue
    
    // [2,0,2,1,1,0]                [0,0,2,1,1,2]                   [0,0,2,1,1,2]                   [0,0,2,1,1,2]       [0,0,1,1,2,2]
    //  l         r     ----->       l         r       ----->          l       r          ----->       l     r             l   r  
    //  i                              i                                 i                               i                   i
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1, i = 0;
        
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, l, i);
                l++;
            } else if (nums[i] == 2) {
                swap(nums,i, r);
                r--;
                i--;
            }
            i++;
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}