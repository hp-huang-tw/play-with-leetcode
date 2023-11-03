class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];    // MAX_VALUE -> 7 -> 1
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
                                                // 5-1=4, 3-1=2, 6-1=5, 4-1=3
            }
        }
        
        return maxProfit;
    }
}