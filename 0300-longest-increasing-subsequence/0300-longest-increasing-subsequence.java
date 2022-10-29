class Solution {
    // Brute force: O(2^n)
    // DP solution: 
    // botton up - O(n^2), O(n)
    public int lengthOfLIS(int[] nums) {
        int arryLen = nums.length;
        int[] lis = new int[arryLen];
        
        int max = 1;
        
        for (int i = arryLen - 1; i > -1; i--) {
            lis[i] = 1;
            for (int j = i + 1; j < arryLen; j++) {
                if (nums[i] < nums[j]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                    max = Math.max(lis[i], max);
                }
            }
        }
        
        return max;
    }
}