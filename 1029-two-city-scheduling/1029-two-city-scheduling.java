class Solution {
    
    // TC: O(nlog(n))
    // OC: O(n^2)
    public int twoCitySchedCost(int[][] costs) {
        int costsLen = costs.length;
        int[][] diffs = new int[costsLen][3]; // diff, costA, costB
        
        // $B-$A
        for (int i = 0; i < costsLen; i++) {
            diffs[i][0] = costs[i][1] - costs[i][0]; 
            diffs[i][1] = costs[i][0];
            diffs[i][2] = costs[i][1];
        }
        
        // 50% cheapest means cost b is more cheap.
        Arrays.sort(diffs, (a, b) -> a[0] - b[0]);
        
        int res = 0;
        int diffsLen = diffs.length;
        for (int i = 0; i < diffsLen; i++) {
            if (i < diffsLen/2) {
                res += diffs[i][2];
            } else {
                res += diffs[i][1];
            }
        }
        return res;
    }
}