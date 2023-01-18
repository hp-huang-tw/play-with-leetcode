class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
           
        for (int num: nums) {                   
            currSum = Math.max(currSum + num, num); // if currSum < 0, currSum = num
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
    
    public int maxSubArrayBasic(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;
           
        for (int num: nums) {                   // -2   1   -3  4  -1   2   1   -5  4
            if (currSum < 0) {                  //. 0. -2    1 -2   4   3   5    6  1   5
                currSum = 0;                    //      0       0
            }
            currSum += num;                     //  -2  1   -2  4   3   5   6   1   5
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
}