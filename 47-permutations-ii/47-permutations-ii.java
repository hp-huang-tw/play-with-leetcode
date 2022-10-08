class Solution {
    
    int[] nums;
    
    List<List<Integer>> res;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        res = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        
        permute(new ArrayList<>(), used);
        return res;
    }
    
    private void permute(List<Integer> permutes, boolean[] used) {
        if (permutes.size() == nums.length) {
            res.add(new ArrayList<>(permutes)); 
            return;
        }
        
        for (int i=0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            permutes.add(nums[i]);
            used[i] = true;
            permute(permutes, used);
            used[i] = false;
            permutes.remove(permutes.size()-1);
        }
    }
}