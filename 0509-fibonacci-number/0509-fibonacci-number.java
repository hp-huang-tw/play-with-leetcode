class Solution {
    public int fib(int n) {
        return fibDp(n);
    }
    
    // TC: O(n), SC: O(n)
    private int fibDp(int n) {
        if(n < 2) return n;
        
        int[] dp = new int[n+1];
        
        //dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}