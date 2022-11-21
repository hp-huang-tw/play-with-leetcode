class Solution {
    
    int[] nums;
    
    int numsLen;
    
    List<List<Integer>> res;
    
    boolean[] used;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        numsLen = nums.length;
        used = new boolean[numsLen];
        res = new ArrayList<>();
        
        Arrays.sort(nums);
        permuteHelper(new ArrayList<>());
        
        return res;
    }
    
    
    // TC: O(n*n!), SC: O(n!)
    private void permuteHelper(List<Integer> permutes) {
        if (permutes.size() == numsLen) {
            res.add(new ArrayList<>(permutes));
            return;
        }
        
        for (int i = 0; i < numsLen; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && used[i-1]) continue;
            permutes.add(nums[i]);
            used[i] = true;
            permuteHelper(permutes);
            used[i] = false;
            permutes.remove(permutes.size() - 1);
        }
    }
}