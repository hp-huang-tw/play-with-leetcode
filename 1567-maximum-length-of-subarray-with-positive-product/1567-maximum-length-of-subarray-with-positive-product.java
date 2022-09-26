class Solution {
    public int getMaxLen(int[] nums) {
        int res=0, countPositive=0, countNegative=0;
        
        for (int i=0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countPositive = 0;
                countNegative = 0;
            } else if (nums[i] > 0) {
                // 1,  -2
                // 1,1 0,2
                countPositive++;
                countNegative = (countNegative == 0) ? 0 : (countNegative + 1);
            } else {
                int tmpPositive = countPositive;
                countPositive = (countNegative == 0) ? 0 : (countNegative + 1);
                countNegative = tmpPositive+1;
            }
            
            res=Math.max(res, countPositive);
        }
        
        return res;
    }
}