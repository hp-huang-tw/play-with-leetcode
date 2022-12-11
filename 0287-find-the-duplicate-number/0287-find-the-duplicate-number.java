class Solution {
    public int findDuplicate(int[] nums) {
        return set(nums);
    }
    
    // TC: O(n), SC: O(n)
    private int set(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        
        for (int num : nums) {
            if (visited.contains(num)) {
                return num;
            }
            
            visited.add(num);
        }
        
        return -1;
    }
    
    // TC: nLog(n), SC: log(n)
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