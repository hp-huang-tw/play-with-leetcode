class Solution {
    
    // brute-force (2^n)
    
    //           1 2 3 1
    //         1          2      3
    //       /  \        /       |
    //      3    1      1       [3]
    //     [4]   [2]   [3] 
    
    
    // 1 2 3 1
    // 1.  4
    //     3
    //   2   3/4
    
    // rob[i] = max(nums[i] + rob[i-2], rob[i-1])
    
    //.r1 r2
    // 0  0  |  1   2   3   1
    // ---------------------------
    //   r1    r2
    //          1
    // ---------------------------
    //          r1 r2
    //              2
    // ---------------------------
    //              r1. r2
    //                  4
    // ---------------------------
    //                  r1. r2
    //                      4
    
    // TC: O(n). SC: O(1)
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        
        for (int n : nums) {
            int nextRob = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = nextRob;
        }
        
        return rob2;
    }
}