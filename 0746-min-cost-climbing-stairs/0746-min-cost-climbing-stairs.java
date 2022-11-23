class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // cost [0] [1] ......... [n-1] [n]
        //                               20
        for (int i = cost.length - 1 - 2; i > -1; i--) {
            cost[i] += Math.min(cost[i+1], cost[i+2]);
        }
        return Math.min(cost[0], cost[1]);
    }
}