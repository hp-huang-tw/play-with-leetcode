class Solution {
    
    private int[] prices;
    private int[][] cache;
    
    public int maxProfit(int[] prices) {
        this.prices = prices;
        cache = new int[prices.length][3];        
        return dfs(0, 0);
    }
    
    
    private int dfs(int i, int status) {
        
        if (i ==  prices.length)
            return 0;
        
        if (cache[i][status] !=0)
            return cache[i][status];
        
        int buyOrSell = 0;

        if (status==0) {
            buyOrSell = dfs(i+1, 1) - prices[i];
        } else if (status==1) {
            buyOrSell = dfs(i+1, 2) + prices[i];
        } else {
            buyOrSell = dfs(i+1, 0);
        }
        
        int coolDown = dfs(i+1, status);
        
        cache[i][status] = Math.max(buyOrSell, coolDown);
        
        return cache[i][status];
    }
}