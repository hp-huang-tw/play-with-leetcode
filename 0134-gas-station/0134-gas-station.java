class Solution {
    // gas =  [1,2,3,4,5] (15)        [2,3,4] (9)
    // cost = [3,4,5,1,2] (15)        [3,4,3] (10)
    //.       -2 -2 -1 3 3             -1-1 1
    
    // TC: O(n), SC: O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
            return -1;
        
        int total = 0;
        int start = 0;
        for (int i = start; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            
            // cannot move i+1th statation from ith
            // try start from next
            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }
        
        return start;
    }
}