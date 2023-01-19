class Solution {   
    
    /*
    // [1, -1, 1, 1, 1, 1],     k = 3   
    //                        sum  sum-k   res      {preSums, count}
    // [1]                      1      2     0      {0,1},{1,1}                 
                                                    [][1]
    // [1, -1]                  0      3     0      {0,2},{1,1}                 
                                                    [][1,-1],[1]         
    // [1, -1, 1]               1      2     0      {0,1},{1,2}                 
                                                    [][1,-1],[1][1,-1,1]
    // [1, -1, 1, 1]            2     -1     0      {0,1},{1,2},{2,1};{3,1}     
    //                                              [][1,-1],[1][1,-1,1],[1, -1, 1, 1]
    // [1, -1, 1, 1, 1]         3      0     2      {0,1},{1,2},{2,1};{3,1}
                                                    [][1,-1],[1][1,-1,1],[1, -1, 1, 1],[1, -1, 1, 1, 1]
    // [1, -1, 1, 1, 1, 1]      4      1     2      {0,1},{1,2},{2,1};{3,1};{4,1}
                                                    [][1,-1],[1][1,-1,1],[1, -1, 1, 1],[1, -1, 1, 1, 1],
                                                    [1, -1, 1, 1, 1, 1]
    */
    // TC: O(n), SC: O(n)
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        
        HashMap<Integer, Integer> preSums = new HashMap<>();
        preSums.put(0, 1);
        
        for (int n: nums) {
            sum += n;
            
            if (preSums.containsKey(sum - k)) {
                res += preSums.get(sum - k);
            }
            
            preSums.put(sum, 1 + preSums.getOrDefault(sum, 0));
        }
        
        return res;
    }
}