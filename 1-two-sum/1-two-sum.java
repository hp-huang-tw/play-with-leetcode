class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        // Brute Force
        O(N^2)
        O(1)
        int[] result=new int[2];

        for(int i=0; i < nums.length; i++) {
            for(int j=i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target) {
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
        */
        
        // Hash Table
        // O(N), O(N)
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) !=i) {
                return new int[] { map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
