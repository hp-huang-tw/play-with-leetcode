class Solution {
    /*
        [4,5,0,-2,-3,1]     sum     sum%5   res     proMod
        [4]                 4       4       0       {0,1}{4,1}          
                                                    [];[4]
        [4,5]            v  9       4       1       {0,1}{4,2}          
                                                    [];[4]
        [4,5,0]          v  9       4       1+2     {0,1}{4,3}          
                                                    [];[4],[4,5],[4,5,0]
        [4,5,0,-2]          7       2       3       {0,1}{4,3}{2,1}     
                                                    [];[4],[4,5],[4,5,0];[4,5,0,-2]
        [4,5,0,-2,-3]    v  9       4       3+3     {0,1}{4,4}{2,1}     
                                                    [];[4],[4,5],[4,5,0],[4,5,0,-2,-3];[4,5,0,-2]
        [4,5,0,-2,-3,1]     10      0
    */
    /*   
    result
            [5], 
            -------------------
            [5, 0], 
               [0], 
            --------------------
                    [-2, -3]
                [0, -2, -3], 
                    
            [5, 0, -2, -3], 
    */
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> preMods = new HashMap<>();
        preMods.put(0, 1);
        
        int sum = 0, res = 0, mod = 0;
        for (int n : nums) {
            sum += n;
            mod = (sum % k) < 0 ? (sum % k) + k: sum % k;
            if (preMods.containsKey(mod)) {
                res += preMods.get(mod);
            }
            preMods.put(mod, 1 + preMods.getOrDefault(mod, 0));
        }
        return res;
    }
}