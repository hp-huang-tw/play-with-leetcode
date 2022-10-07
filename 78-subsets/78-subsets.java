class Solution {
    
    int[] nums;
    List<List<Integer>> res;
    
    public List<List<Integer>> subsets(int[] nums) {
        this.nums=nums;
        res = new ArrayList<List<Integer>>();
        helper(0, new ArrayList<Integer>());
        return res;
    }
    
    // [[], [1], [1,2], [1,2,3], [2], [2, 3], [3]]
    private void helper(int offset, List<Integer> subsets) {
        res.add(new ArrayList<Integer>(subsets));
        for (int i = offset; i < nums.length; i++) {
            int num = nums[i];
            subsets.add(num);
            helper(i + 1, subsets);
            subsets.remove(subsets.size()-1);
        }
    }
}