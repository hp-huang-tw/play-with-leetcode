class Solution {
    /*
        [4,5,0,-2,-3,1]     sum     sum%5   res     proMod
        [4]                 4       4       0      {0,1}{4,1}       [];[4]
        [4,5]            v  9       4       1      {0,1}{4,1}{9,1}  [];[4];[4,5]
        [4,5,0]          v  9       4       1+2
        [4,5,0,-2]          7       2       3      {0,1}{4,1}{9,1}{7,1}
        [4,5,0,-2,-3]    v  9       4       3+3
        [4,5,0,-2,-3,1]     10      0
        
        
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
        int[] map = new int[k];
		map[0] = 1;
        int res = 0, sum = 0;
        for(int n : nums) {
            sum = (sum + n) % k;
            if(sum < 0) sum += k;  // Because -1 % 5 = -1, but we need the positive mod 4
            res += map[sum];
            map[sum]++;
        }
        return res;
    }
}