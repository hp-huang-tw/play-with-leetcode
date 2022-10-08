class Solution {
    
    int[] candidates;
    
    List<List<Integer>> res;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        res = new ArrayList<List<Integer>>();
        
        helper(new ArrayList<Integer>(), target, 0);
        return res;
    }
    
    private void helper(List<Integer> pickedNums, int remain, int offset) {
        if (remain < 0) return;
        if (remain == 0) {
            res.add(new ArrayList<>(pickedNums));
            return;
        }
        
        for (int i = offset; i < candidates.length; i++) {
            int num = candidates[i];
            pickedNums.add(num);
            helper(pickedNums, remain - num, i);
            pickedNums.remove(pickedNums.size()-1);
        }
    }
}