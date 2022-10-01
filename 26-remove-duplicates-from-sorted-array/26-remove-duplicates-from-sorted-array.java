class Solution {
    // [1,1,2]
    // [0,0,1,1,1,2,2,3,3,4]
    //. L   R
    //.[0 1 1,1,1,2,2,3,3,4]
    //.   L       R
    ///[0 1 2 1 1 2 2 3 3 4]
    //.     L         R 
    //.[0 1 2 3 1 2 2 3 3 4]
    //.       L           R
    //.[0 1 2 3 4 2 2 3 3 4]
    //.         L         R
    public int removeDuplicates(int[] nums) {
        int k=0;
        int left=0, right=1;
        
        if (nums.length <= 1) return 1;
        
        while (right < nums.length) {
            if (nums[right] > nums[left]) {
                nums[left+1] = nums[right];
                left++;
            } else {
                right++;
            }
        }
        
        return left + 1;
    }
}