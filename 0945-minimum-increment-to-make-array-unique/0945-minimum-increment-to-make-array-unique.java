class Solution {
    
    // TC: O(nlog(n))
    // SC: O(1);
    public int minIncrementForUnique(int[] nums) {
        int numsLen = nums.length;
        if (numsLen == 0) return 0;
        
        Arrays.sort(nums);
        
        int res = 0;
        
        for (int i = 1; i < numsLen; i++) {
            // if current is samller or equals to prev
            // 1 1 2 2 3 7
            // 1 2 2 2 3 7
            // 1 2 3 2 3 7
            // 1 2 3 4 3 7
            // 1 2 3 4 5 7
            if (nums[i] <= nums[i-1]) {
                int diff = nums[i-1] - nums[i] + 1;
                res += diff;
                nums[i] += diff;
            }
        }
        return res;
    }
    
}