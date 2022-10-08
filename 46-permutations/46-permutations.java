class Solution {
    
    int[] nums;
    
    List<List<Integer>> res;
        
    public List<List<Integer>> permute(int[] nums) {
        this.nums= nums;
        res = new ArrayList<List<Integer>>();
        permute(new ArrayList<>());
        return res;
    }
    
    
    private void permute (List<Integer> permutes) {
        if (permutes.size() == nums.length) {
            res.add(new ArrayList<>(permutes));
            return;
        }      
        
        for (int n: nums) {
            if (permutes.contains(n)) continue;
            permutes.add(n);
            permute(permutes);
            permutes.remove(permutes.size() -1);   
        }
    }
}