class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int val = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (val == nums[i]) return true;
            val = nums[i];
        }
        
        return false;
    }
}