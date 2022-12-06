class Solution {
    //  Loop the array and get the value nums[i] 
    // then we need to find a value nums[j] such that nums[i] + nums[j] < k
    // which means nums[j] < k - nums[i]. 
    // In order to do that we can find that value with a binary search.
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                res = Math.max(res, sum);
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}