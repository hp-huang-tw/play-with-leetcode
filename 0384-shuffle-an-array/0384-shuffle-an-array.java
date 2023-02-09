class Solution {
    
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
        int numsLen = nums.length;
        for (int i = 0; i < numsLen; i++) {
            swap(nums, i, random(i, numsLen - 1));
        }
        return nums;
    }
    
    private int random(int i, int j) {
        return i + rand.nextInt(j - i + 1);
    }
    
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */