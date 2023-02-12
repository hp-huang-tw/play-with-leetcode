class Solution {
    // nums=[2,7,11,15], target=9
    // res=[0, 1]
    // O(n), O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complement = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (complement.containsKey(n)) {    // 2, 7
                return new int[] { complement.get(n), i}; // [0, 1]
            }
            complement.put(target - nums[i], i); //7:0
        }
        
        return new int[]{};
    }
}