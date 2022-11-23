class Solution {
    public int coinChange(int[] coins, int amount) {

        // dp[0][1][2][3][4].....[11]
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        
        dp[0]=0; // -> key!!!!
        
        // iterate dp table current amount
        for(int i=1; i<=amount; i++) {
            // iterate coins...[1, 2, 5]
            for(int j = 0; j < coins.length; j++) {
                if (i-coins[j] < 0) continue; // i=1,  
                dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                // (11, dp[1-1] + 1)
                
            }
            // System.out.format("%d th dp: %d\n", i, dp[i]);
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
            
    }
    // target = 11
    // dp bottom-up
    // fill new int[amount + 1], amount + 1
    
    // dp[]                     coins (j)
    // i\c   1     2     5          [1, 2, 5]
    // 0     0     -     -
    // 1   11->1   
    // 2   11->1
    // 3   11->1
    // 4   11->2
    // 5   11->1
    // 6   11->2
    // .
    // 10      2
    // 11. 2 + 1 
}