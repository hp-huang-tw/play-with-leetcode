class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        
        return maxProfit;
    }
}


// prices = [7,1,5,3,6,4]
//           b s           s-b -6        // maxProfit = 0
//               s             -2
//                 s
//             b s         maxProfit = 4
//                 s       maxProfit = 4
//                   s     maxProfit = 5
//     return maxProfit; //5 

// O(n^2), O(1)
          
// int minPrice = 7; // prices[0];

// prices = [7,1,5,3,6,4]
//           ^             // i=1;
//           m i           // maxProfit = 0
//             m i         // max = 4
//             m     i     // maxProfit = 5
//                      i
                     