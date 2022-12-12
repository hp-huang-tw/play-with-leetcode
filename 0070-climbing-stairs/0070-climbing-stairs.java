class Solution {
    
    // can take 1 or 2 step
    // n=1 1                     | 1
    // n=2 1
    //     1 2                   | 2
    // n=3 1,1, 1 | 1,2 | 2,1    | 3
    // n=4 
    //. 1,1,1,1 
     // 1,2,1 
    //. 1,1,2
    //. 2.2
    //  2,1,1                    | 5
    
    public int climbStairs(int n) {        
        int[] dp = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            if (i < 4) {
                dp[i] = i;
            } else {
                dp[i] = dp[i -1] + dp[i - 2];
            }
        }
        
        return dp[n];
    }
}