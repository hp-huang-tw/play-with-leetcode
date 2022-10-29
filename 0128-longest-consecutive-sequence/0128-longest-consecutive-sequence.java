class Solution {
    // sorted solution: O(nlogn)
    // O(n), O(n)
    public int longestConsecutive(int[] nums) {
        // O(n)
        Set<Integer> numsSet = new HashSet<>();
        for (int n : nums){
            numsSet.add(n);
        }
        
        int longest = 0;
        
        for (int num : numsSet) {
            // check if is a start elemnet 1 3 2
            if (!numsSet.contains(num - 1)) {
                int length = 0;
                
                // start find the end from the start element
                while (numsSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}