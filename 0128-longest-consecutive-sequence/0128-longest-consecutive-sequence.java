class Solution {
    // sorted solution: 
    // Step1. sort by ascending. O(nlogn)
    // Step2. count + 1
    // SC: O(1)
    
    // Union Find solution
    // TC: O(n)
    // SC: O(n). store nums to hash set to look up. similar with HashTable solution
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        
        for (int num : nums) {
            numsSet.add(num);
        }
        
        int longest = 0;
        
        // iterate through nums. O(n)
        for (int currNum : nums) {
            // check whether current number is start of the sequence
            //    100 4 200 1 3 2
            //-->  | 1.2 3 4 | ....|100|....|200|....
            if (!numsSet.contains(currNum - 1)) {
                int count = 0;

                // count how many consecutive nums exists from current number
                while (numsSet.contains(currNum + count)) {
                    count++;
                }

                longest = Math.max(longest, count);
            }            
        }
        
        return longest;
    }
}