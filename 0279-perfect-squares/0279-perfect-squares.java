class Solution {
    
    // x
    // 12/2 = 6 ->  1, 4(2),      1, 4(2),9(3)
    //               /                  \
    //              4                     9
    //              /                       \
    //            4, 4                       9, 1
    //            /                             \
    //          4, 4 , 4                        9, 1, 1
    //                                            \
    //                                             9, 1, 1, 1
    // cannot be a greedy solution
    
    // dynamic programing (bottom-up)
    // dp[i] 0  1  2  3  1  2 .... ?
    //    i  0  1  2  3  4  5 .... n 
    
    // TC: O(n* (n^1/2)), OC: O(n)
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // based case
        dp[0] = 0;
        
        for (int i = 1; i < n + 1; i++) {
            for (int s = 1; s < n + 1; s++) {
                int square = s * s;
                if (i < square) {   // i=1, s=2*2
                    break;
                }
                // i=1, square=1*1, dp[1-1] = dp[0] = 0 -> dp[1] = dp[0] + 1
                // i=2, square=1*1, dp[2-1] = dp[1] = 1 -> dp[2] = dp[1] + 1 = 2
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);   
            }
        }
        
        return dp[n];
  }
}