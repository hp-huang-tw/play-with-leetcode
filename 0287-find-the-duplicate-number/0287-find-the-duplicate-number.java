class Solution {
    
    // similar problem: https://leetcode.com/problems/linked-list-cycle-ii/solution/#approach-2-floyds-tortoise-and-hare-accepted
    public int findDuplicate(int[] nums) {
        return floydCylcleDetection(nums);
    }
    
    
    // Floyd's Cycle Detection 
    // 0 , 1  2  3  4       covert to linked list
    // 1   3. 4. 2. 2       ------>  (1@0) -> (3@1) -> (2@3) -> (4@2) -> (2@4)
    // O(n), O(1) without modifying nums
    private int floydCylcleDetection(int[] nums) {
        int slow = 0, fast = 0;
        
        while (true) {
            slow = nums[slow];          // move one step
            fast = nums[nums[fast]];    // move two step
            if (nums[slow] == nums[fast])
                break;
        }
        
        int slow2 = 0;
        while (nums[slow] != nums[slow2]) {
            slow = nums[slow];          // move one step
            slow2 = nums[slow2];
            // if (nums[slow] == nums[slow2])
            //     return nums[slow];
        }
        return nums[slow];
    }
    
    // TC: o(n), SC: o(1)
    // similar problem:
    // https://leetcode.com/problems/first-missing-positive/
    private int negativeMarking(int[] nums) {
        int duplicate = -1;
        
        for (int i = 0; i < nums.length; i++) { 
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {    
                duplicate = cur;    // nums[cur] already flipped, so it's duplicate
                break;
            }
            nums[cur] *= -1;
        }
        
        // Restore numbers
        // for (int i = 0; i < nums.length; i++) {
        //      nums[i] = Math.abs(nums[i]);
        // }
        
        return duplicate;
    }
    
    // TC: O(n), SC: O(n)
    private int set(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        
        for (int num : nums) {
            if (visited.contains(num)) {
                return num;
            }
            
            visited.add(num);
        }
        
        return -1;
    }
    
    // TC: nLog(n), SC: log(n)
    private int sort(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        
        return -1;
    }
    
    // [7,9,7,4,2,8,7,7,1,5]
    
    // [1,2,4,5,7,7,7,7,8,9]
    //.     ^
}