class Solution {
    int[] nums;
    
    int n;
    
    List<List<Integer>> res;
    
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        n = nums.length;
        
        res = new ArrayList<>();
        permuteHelper(new ArrayList<>());
        
        return res;
    }
    
    // TC: O(n*n!), SC:(n!)
    // ref: https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
    private void permuteHelper(List<Integer> permutes) {
        if (permutes.size() == n) {
            res.add(new ArrayList<>(permutes));
            return;
        }
        
        for (int n : nums) {
            if (permutes.contains(n)) continue;
            permutes.add(n);
            permuteHelper(permutes);
            permutes.remove(permutes.size() - 1);
        }
    }
    
}