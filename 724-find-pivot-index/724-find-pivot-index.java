class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0, leftSum=0;
        
        for(int i=0; i < nums.length; i++) {
            sum+=nums[i];
        }
        
        for(int i=0; i < nums.length; i++) {
            if (i>0) {
                leftSum=leftSum+nums[i-1];
            }
            if (leftSum==sum-nums[i]-leftSum) return i;
        }
            
        return -1;
    }
}