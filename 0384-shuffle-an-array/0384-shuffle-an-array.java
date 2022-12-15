class Solution {

    // Fisher-Yates Algorithm
    int[] nums;
    
    int[] original;
    
    Random rand = new Random();
    
    public Solution(int[] nums) {
        this.nums = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        nums = original.clone();
        return nums;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            swap(nums, i, randomRange(i, nums.length));
        }
        return nums;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private int randomRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */