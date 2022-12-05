class Solution {
    
    // case 1
    // nums = [0,1,3,50,75], lower = -2, upper = 99
    // Output: ["-2->-1", "2","4->49","51->74","76->99"]
    
    // case 2
    // nums = [], lower = -2, upper = 99
    // Output: ["-2->99"]
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        
        int numsLen = nums.length;
        
        if (numsLen == 0) {
            res.add(formatRange(lower, upper));
            return res;
        }
                    
        if (lower < nums[0]) {
            res.add(formatRange(lower, nums[0] - 1));
        }
        
        
        for (int i = 0; i < numsLen - 1; i++) {
            int currNum = nums[i];
            int nextNum = nums[i + 1];
            if (nextNum > currNum + 1) {
                res.add(formatRange(currNum + 1, nextNum - 1));
            }
        }
        
        int lastNum = nums[numsLen -1];
        if (upper > lastNum) {
            res.add(formatRange(lastNum + 1,upper));
        }
        
        return res;
    }
    
    // 2, 2.  2
    // 2, 3.  2->3 
    private String formatRange(int start, int end) {
        return (start == end) ? String.valueOf(start) : 
        String.valueOf(start) + "->" + String.valueOf(end);
    }
}