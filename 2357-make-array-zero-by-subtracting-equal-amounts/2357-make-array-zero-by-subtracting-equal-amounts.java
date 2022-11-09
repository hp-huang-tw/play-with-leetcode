class Solution {
    
    // TC: O(n), SC: O(n)
    public int minimumOperations(int[] nums) {
        
        // nums of unique value is equal to nums of operation
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        
        return set.size();
        
    }
}