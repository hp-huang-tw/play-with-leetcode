class Solution {
    public boolean containsDuplicate(int[] nums) {
        return sort(nums);
    }
    
    // Time: O(nLog(n)), Space: O(1)
    private boolean sort(int[] nums) {
        Arrays.sort(nums);
        
        for (int i=0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) return true;
        }
        
        return false;
    }
    
    // Time: O(N), Space: O(N)
    private boolean hashSet(int[] nums) {
        Set<Integer> hitNum = new HashSet<Integer>();
        
        for (int num : nums){
            if (hitNum.contains(num)) return true;
            hitNum.add(num);
        }
        return false;
    }
    
    // Time: O(N^2), Space: O(1)
    private boolean twoPointer(int[] nums) {
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i]==nums[j]) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
}