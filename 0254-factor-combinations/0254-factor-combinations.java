class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    List<Integer> factors = new ArrayList<>();
    
    public List<List<Integer>> getFactors(int n) {
        optimalHelper(n, 2);
        return result;
    }
    
    public void optimalHelper(int n, int start) {
            //System.out.format("n=%d, start=%d\n", n, start);

            // a/b = q...r
            //                 [b, q]
            // choose quotient [2, 6]
            if (!factors.isEmpty()) {
                factors.add(n);
                //System.out.format("[added q] n=%d, start=%d, factors: %s\n", n, start, factors.toString());
                result.add(new ArrayList<>(factors));
                factors.remove(factors.size() - 1);
                //System.out.format("[removed q] n=%d, start=%d, factors: %s\n", n, start, factors.toString());
            }

            // not choose quotient, lookup divisor(b) from 2 to n/2 (i.e. 2-3)
            for (int i = start; i <=  n / i; i++) {
                int nextVale = n / i;
                if (n % i == 0) {
                    factors.add(i);
                    //System.out.format("[added b] n=%d, start=%d, factors: %s\n", n, start, factors.toString());
                    // System.out.format("[next call] n=%d, start=%d\n", nextVale, start);
                    optimalHelper(nextVale, i);
                    factors.remove(factors.size() - 1);
                    // System.out.format("[removed b] n=%d, start=%d, factors: %s\n", n, start, factors.toString());
                }
            }
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