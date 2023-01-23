class Solution {
    
    /*
    input: [1,0,-1,0,-2,2]
               1                                    0           -1
              /         \         \                / \           |       
             0          -1         0             -1   0          0
          /    \        /   \       |            /   |           |
        -1 (0)  -2(-1) 0(0)  -2(2)  -2(-1)     0(1) -2(2)      -2(-3)
        / |   \     \         |                 |            
       0 -2(x) 2(x)  2(x)     2                 2            
    
    output: [1,0,-1,0],[1,-1,-2,2],[0,0,-2,2]
    */
    
    // kSum + two sum
    // find all possible permutes k-2 nums
    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    // [-2,-1,0,0,1,2]
    
    int[] nums;
    
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        this.nums = nums;
        Arrays.sort(nums);
        kSumHelper(4, 0, target, new ArrayList<>());
        return res;
    }
    
    private void kSumHelper(int k, int start, long target, List<Integer> quad) {
        if (k != 2) {
            for (int i = start; i < nums.length - k + 1; i++) {
                if (i > start && nums[i] == nums[i-1])
                    continue;
                quad.add(nums[i]);
                kSumHelper(k - 1, i + 1, target - nums[i], quad);
                quad.remove(quad.size() - 1);
            }
            return;
        }
        
        // two sum
        int l = start, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] < target) {
                l += 1;
            } else if (nums[l] + nums[r] > target) {
                r -= 1;
            } else {
                List<Integer> quadRes = new ArrayList<>(quad);
                quadRes.add(nums[l]);
                quadRes.add(nums[r]);
                res.add(quadRes);
                l += 1;
                while (l < r && nums[l] == nums[l - 1]) {
                    l += 1;
                }
            }
        }
    }
}