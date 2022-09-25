class Solution {
    public int[] runningSum(int[] nums) {
        int[] runningSums = new int[nums.length];
        
        for(int i=0; i< nums.length; i++) {
            if (i>0) {
                runningSums[i]=runningSums[i-1]+nums[i];
            } else {
                runningSums[i]=nums[i];
            }
        }
        return runningSums;
    }
}