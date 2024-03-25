class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count++;
            } else if (res == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        
        return res;
    }
    
}

/*
[2,2,1,1,1,2,2]
*/