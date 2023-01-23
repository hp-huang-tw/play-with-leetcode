class Solution {
    
    int[] nums;
    
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> threeSum(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        kSumHelper(3, 0, 0, new ArrayList<>());
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

    
    // TC: O(n^2)
    public List<List<Integer>> threeSumI(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    
                    while (nums[l] == nums[l-1] && l < r) {
                        l++;
                    }
                }
            }
        }
        
        return res;
    }
}