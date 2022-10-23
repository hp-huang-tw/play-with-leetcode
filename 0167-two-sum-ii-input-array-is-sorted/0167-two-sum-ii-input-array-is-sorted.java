class Solution {
    // TC: O(n)
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        
        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target){
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        
        return new int[]{};
    }
}