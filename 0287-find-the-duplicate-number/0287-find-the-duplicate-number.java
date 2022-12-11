class Solution {
    public int findDuplicate(int[] nums) {
        return sort(nums);
    }
    
    
    // nLog(n)
    private int sort(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        
        return -1;
    }
    
    // [7,9,7,4,2,8,7,7,1,5]
    
    // [1,2,4,5,7,7,7,7,8,9]
    //.     ^
}