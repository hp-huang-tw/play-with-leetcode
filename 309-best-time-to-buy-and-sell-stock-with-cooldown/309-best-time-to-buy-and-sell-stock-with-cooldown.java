class Solution {
    
    private int[] prices;
    
    private int[][] mem;
    
    public int maxProfit(int[] prices) {
        this.prices=prices;
        mem = new int[prices.length][2];
        return calcMProfit(0, 0);
    }
    
    // dfs: O(n), O(n). with memorization
    // action: buy=0, sell=1
    int calcMProfit(int i, int action){
        if(i >= prices.length){
            return 0;
        }
        
        if (mem[i][action] != 0) return mem[i][action];
        
        int profit=0;
        int cooldown = calcMProfit(i+1, action); 
        if (action == 0) { // buy
            int buy = -prices[i] + calcMProfit(i+1, action+1);
            profit = Math.max(buy, cooldown);
        } else { // sell
            int sell = prices[i] + calcMProfit(i+2, action-1);
            profit = Math.max(sell, cooldown);
        }
        
        mem[i][action]=profit;
        return profit;
    }
}