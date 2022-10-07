class Solution {
    
    public int majorityElement(int[] nums) {
       return sort(nums);
    }
    
    // sort: O(n), O(1)
    public int sort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    
}