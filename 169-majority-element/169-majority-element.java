class Solution {
    // HashMap: O(n), O(n)
    // O(n), O(1)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}