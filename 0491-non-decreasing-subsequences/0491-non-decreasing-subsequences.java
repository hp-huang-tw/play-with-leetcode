class Solution {
        
    int[] nums;
    
    HashSet<List<Integer>> res = new HashSet<>();
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        dfs(0, new LinkedList<>());
        return new ArrayList<>(res);
    }
    
    /*
    // [4,6,7,7]
    //         4         6.     7   7
        /.     |  \     /  \    |   x
        6      7   7   7    7   7
      / | \   / \     / \
     7  7    7       7
     |
     7
    */ 
    private void dfs(int i, List<Integer> subsequences) {
        if (subsequences.size() > 1) {
            res.add(new ArrayList<>(subsequences));
        }
        
        for (int j = i; j < nums.length; j++) {
            if (subsequences.size() == 0 || nums[j] >= subsequences.get(subsequences.size() - 1)) {     
                subsequences.add(nums[j]);
                dfs(j + 1, subsequences);
                subsequences.remove(subsequences.size() - 1);
            }
        }
    }
}