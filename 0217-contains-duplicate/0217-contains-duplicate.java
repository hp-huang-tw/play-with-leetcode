class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        
        for (int n : nums) {
            if (numsSet.contains(n)) return true;
            numsSet.add(n);
        }
        
        return false;
    }
}