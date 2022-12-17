class Solution {                                                       
    //       [1, -1, 1, 1, 1, 1],     k = 3                    
    //       [1]        [1, -1]    [1, -1, 1]   [1, -1, 1, 1]   [1, -1, 1, 1, 1]        [1, -1, 1, 1, 1, 1]                    
    // sum    1          0             1              2               3                       4
    //.      1-3=-2     0-3 = -3     1-3=-2         2-3= -1         3-3=0                   4-3=1
    // res    0                                                       2                       4
    
    /*
        preSums count
-       ---------------
         0       1->2       [ ], [1,-1]
         1       1->2       [1], [1,-1,1]   
         2.      1          [1,-1,1,1]
         3.      1          [1,-1,1,1,1]
    */
    
    // TC: O(n), SC: O(n)
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSums = new HashMap<>();
        preSums.put(0, 1);
        
        int sum = 0;
        int res = 0;
        
        for (int n : nums) {
            sum += n;
            
            if (preSums.containsKey(sum - k)) {
                res += preSums.get(sum - k);
            }
            
            preSums.put(sum, 1 + preSums.getOrDefault(sum, 0));
        }
        
        return res;
    }
}