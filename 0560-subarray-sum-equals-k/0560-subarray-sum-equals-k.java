class Solution {
    
    // TC: O(n), SC: O(n)
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSums = new HashMap<Integer, Integer>();
        preSums.put(0, 1);
        int count = 0;
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (preSums.containsKey(sum-k)) {
                count += preSums.get(sum-k);
            }
            
            preSums.put(sum, preSums.getOrDefault(sum, 0) +1);
        }
        
        return count;
    }
}