class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max=1, min=1;
        
        for (int n: nums) {
            int preMax = max;
            max = Math.max(n, Math.max(n*max, n*min));
            min = Math.min(n, Math.min(n*preMax, n*min));
            res = Math.max(res, max);
        }
        return res;
    }
}