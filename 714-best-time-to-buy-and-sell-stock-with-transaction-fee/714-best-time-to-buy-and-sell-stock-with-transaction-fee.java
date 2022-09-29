class Solution {
    
    private int[] prices;
    
    private int fee;
    
    private int[][] mem;
    
    public int maxProfit_(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
    
    // Greedy Algo
    public int maxProfit(int[] prices, int fee) {
        int lowPrice = prices[0];
        int totalProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowPrice) { // buy lowest
                lowPrice = prices[i];
            } else if (prices[i] > lowPrice + fee) { // sell highest
                totalProfit += prices[i] - lowPrice - fee;
                lowPrice = prices[i] - fee; // should buy lower than sellPrice - fee
            }
        }
        return totalProfit;
    }
    
    public int maxProfit_recusionWithMem(int[] prices, int fee) {
        
        this.prices = prices;
        this.fee = fee;
        
        mem = new int[prices.length][2];
        
        return calcProfit(0, 0);
       
    }
    
    // action: 0=buy, 1=sell
    private int calcProfit(int ithDay, int action) {
        if (ithDay == prices.length) return 0;
        
        if (mem[ithDay][action] !=0) return mem[ithDay][action];
        
        int profit = 0;
        int cooldown = calcProfit(ithDay+1, action); 
        if (action==0) {
            int buy =  -prices[ithDay] + calcProfit(ithDay+1, action+1);
            profit = Math.max(buy, cooldown);
        } else {
            int sell = prices[ithDay] + calcProfit(ithDay+1, action-1) - fee;
            profit = Math.max(sell, cooldown);
        }
        
        mem[ithDay][action]=profit;
        
        return profit;
    }
    
}