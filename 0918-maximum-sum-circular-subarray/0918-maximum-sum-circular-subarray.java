class Solution {
    // case i =  [ ..,{ .., .., .. }, .. ] -> same as max sub array 
    // https://leetcode.com/problems/maximum-subarray
    
    // case ii = [ ..}, , , { .., .. ]  -> total - mininmal
    
    // edge case: all nums in arrays are zero or negetive
    // e.g. -3 -2 -3 => total = -8
    //               => maxSum = -2, minSum = -8
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currMax = 0;
        
        int minSum = Integer.MAX_VALUE;
        int currMin = 0;
        int total = 0;
           
        for (int num: nums) {                   
            currMax = Math.max(currMax + num, num); // if currMax < 0, currMax = num
            maxSum = Math.max(maxSum, currMax);
            
            currMin = Math.min(currMin + num, num); // if currMin > 0, currMin = num
            minSum = Math.min(minSum, currMin);
            total += num;
        }
        
        if (maxSum <= 0) return maxSum;
        return Math.max(maxSum, total - minSum);
    }
    
}