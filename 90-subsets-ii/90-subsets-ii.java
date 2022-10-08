class Solution {
    
    int[] nums;
    
    List<List<Integer>> res;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums=nums;
        res = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        helper(0, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(int offset, List<Integer> subsets) {
        res.add(new ArrayList<Integer>(subsets));
        for (int i = offset; i < nums.length; i++) {
            if (i > offset && nums[i] == nums[i-1]) continue;
            int num = nums[i];
            subsets.add(num);
            helper(i + 1, subsets);
            subsets.remove(subsets.size()-1);
        }
    }
}