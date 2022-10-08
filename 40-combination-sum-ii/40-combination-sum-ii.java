class Solution {
    
    int[] candidates;
    
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 1 1 2 5 6 7 10
        this.candidates = candidates;
        res = new ArrayList<List<Integer>>();
        
        Arrays.sort(candidates);
        helper(new ArrayList<Integer>(), target, 0);
        return res;
    }
    
    private void helper(List<Integer> combs, int remain, int offset) {
        if (remain < 0) return;
        if (remain == 0) {
            res.add(new ArrayList<>(combs));
            return;
        }
        
        for (int i = offset; i < candidates.length; i++) {
            if (i > offset && candidates[i] == candidates[i-1]) continue;
            int num = candidates[i];
            combs.add(num);
            helper(combs, remain - num, i + 1);
            combs.remove(combs.size()-1);
        }
    }
}

//   [1]
//   [1, 1]                                [1,2]
//.  [1, 1, 2] [1, 1, 5] [1, 1, 6]
//   [1, 1, 2, 5] [1, 1, 5, 6]