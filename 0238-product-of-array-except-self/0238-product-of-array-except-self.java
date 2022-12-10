class Solution {

    public int[] productExceptSelf(int[] nums) {
        return prefixPostfix(nums);
    }
    
    
    // result[i]=prefixs[i-1]*postfixs[i+1].  TC: O(n). SC:(n)
    // nums       [1, 2, 3, 4]
    // prefixs     1  2. 6. 24
    // postfixs.   24 24 12  4       
    // result      24 12  8  6
    private int[] prefixPostfix(int[] nums) {
        int nLen = nums.length;
        int[] prefixs = new int[nLen];
        int[] postfixs = new int[nLen];
        int[] res = new int[nLen];
        
        // create prefixs
        int prev = 1;
        for (int i = 0; i < nLen; i++) {
            prefixs[i] = prev * nums[i];
            prev = prefixs[i];
        }
        
        // create postfixs
        int post = 1;
        for (int i = nLen - 1; i > -1; i--) {
            postfixs[i] = post * nums[i];
            post = postfixs[i];
        }
        
        // create result
        for (int i = 0; i < nLen; i++) {
            if (i == 0) {
                res[i] = postfixs[i + 1];
            } else if (i == nLen - 1) {
                res[i] = prefixs[i - 1];
            } else {
                res[i] = prefixs[i - 1] * postfixs[i + 1];
            }
        }
        
        return res;
    }
}