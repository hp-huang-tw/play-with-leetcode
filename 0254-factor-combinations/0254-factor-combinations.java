class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    List<Integer> factors = new ArrayList<>();
    

    public List<List<Integer>> getFactors(int n) {
        helper3(n, 2);
        return result;
    }

    // n        start     i          factors              
    //                                            /                   \ 
    // 12         2       2                      [2]                  [3]
    //                                     /      |       \            /
    // r1) 12/2=6 2       2             [2, 2]  [2, 3]  [2, 6]      [3, 4]
    //                                  /         |           
    // r2) 6/2=3  2->3   2->3    [2, 2, 3]      [2, 3, 2]  <- repeated 
    //`r3) 3/3=1  3       3      add factors to result[[2, 2, 3], ]       
    
    // Time: O(n *logn)
    // Space: O(logn)
    public void helper(int n, int start){
        if (n <= 1) {
            if (factors.size() > 1) {
                result.add(new ArrayList<>(factors));
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                helper(n/i, i);
                factors.remove(factors.size() - 1); 
            }
        }
    }
    
    public void helper3(int n, int start){
        if (!factors.isEmpty()) {
            factors.add(n);
            result.add(new ArrayList<>(factors));
            factors.remove(factors.size() - 1); 
        }

        for (int i = start; i <= n / i; i++) {
            if (n % i == 0) {
                factors.add(i);
                helper3(n/i, i);
                factors.remove(factors.size() - 1); 
            }
        }
    }
    
    private void helper2(int n, int start) {
        if (n == 1) {
        	if (factors.size() > 1) {
        		result.add(new ArrayList<>(factors));
        	}
            return;
        }
	        
        
        for (int i = start; i <= (int) Math.sqrt(n); i++) {  // ==> here, change 1
            if (n % i != 0) {
                continue;
            }   
            factors.add(i);
            helper2(n/i, i);
            factors.remove(factors.size()-1);
        }
        
        int i = n; // ===> here, change 2
        factors.add(i);
        helper2(1, i);
        factors.remove(factors.size()-1);
    }
}