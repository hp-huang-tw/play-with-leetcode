class Solution {
    /*
        bellman-Ford
        flights=[[0,1,100],[1,2,100],[0,2,500]]
        src=0, dst=2
        
        i=0 
          city  0       1       2                   0       1       2               0       1       2
        prices  0       +inf    +inf                                                0       100     500
                                            ---->                           ---->
          city  0       1       2
        tmps    0        +inf   +inf                0       100     500             0       100     500
        ---------------------------------
        i=1 
          city  0       1       2
        prices  0       100    500                                                  0       100     200
                                            ---->                           ---->
          city  0       1       2
        tmps    0       100     500                 0       100     200             0       100     200
        
        -> k = 1 return 200
        -> k = 0 return 500        
    */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n], tmpPrices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        
        for (int i = 0; i < k + 1; i++) {
            tmpPrices = prices.clone();
            
            for (int[] flight : flights) {
                int s = flight[0], d = flight[1], p = flight[2];
                if (prices[s] == Integer.MAX_VALUE) continue;
                if (prices[s] + p < tmpPrices[d]) {
                    tmpPrices[d] = prices[s] + p;
                }
            }
            
            prices = tmpPrices;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}