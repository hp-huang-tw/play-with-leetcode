class Solution {
    
    // TC: O(n). SC(1)
    public void rotate(int[] nums, int k) {
        int numsLen = nums.length;          // 1,2,3,4,5,6,7
        
        k = k % numsLen;   // e.g. [1], 3
        reverse(nums, 0, numsLen - 1);      // 7,6,5,4,3,2,1
        reverse(nums, 0, k -1);             // 5 6 7|4 3 2 1
        reverse(nums, k, numsLen -1);       // 5 6 7|1 2 3 4
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
