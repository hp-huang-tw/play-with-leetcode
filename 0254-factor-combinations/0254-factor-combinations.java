class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    List<Integer> factors = new ArrayList<>();
    

    public List<List<Integer>> getFactors(int n) {
        helper(n, 2);
        return result;
    }

    // n                factors
    // 12               [2]
    // 12/2=6           [2, 2]
    // 6/2=3            [2, 2, ]  
    //          
    public void helper(int n, int start){
        if (n <= 1) {
            if (factors.size() > 1) {
                result.add(new ArrayList<>(factors));
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);  // [2, 
                helper(n/i, i);
                factors.remove(factors.size() - 1); 
            }
        }
    }
    
}