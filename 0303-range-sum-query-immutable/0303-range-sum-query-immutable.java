class NumArray {
    
    private int[] nums;
    
    // <(left, right), sume>
    private HashMap<Pair<Integer, Integer>, Integer> preSumMap = new HashMap<>();
    
    private int[] preSums;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        preSumOptimization();        
    }
    // [0, 1, 2, 3, 4] (1-3) -> 1 + 2 + 3 = 6
    // sum[0] = 0; 
    // sum[1] = sum[0] + nums[0]; // 10 -> sum[i]
    
    // sum[2] = sum[1] + nums[1]; // 10 + 1
    // sum[3] = sum[2] + nums[2]; // 10 + 1 + 2 = 3 -> sum[j]
    // sum[4] = sum[3] + nums[3]; // 10 + 1 + 2 + 3 = 6 -> sum[j+1]
    // sum[5] = sum[4] + nums[4]; // 10 + 1 + 2 + 3 + 4 = 10
    
    // --- preCal to array ---
    // TC: O(n), SC: O(n)
     private void preSumOptimization() {
        int len = nums.length;
        this.preSums = new int[len + 1];
         
        for (int i = 0; i < len; i++) {
            preSums[i + 1] = preSums[i] + nums[i];
        }
    }
    
    // query TC: O(1)
    public int sumRange(int left, int right) {
        return preSums[right + 1] - preSums[left];
    }
    
    // --- preCal to HashMap ---
    // preCal: TC: O(n^2), SC: O(n^2) for store hashMap
    private void preSumMap() {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            // 0    // 0 1     // 0 1 2     // 0 1 2 3
            // 1    // 1 2     // 1 2 3
            // ....
            for (int j = i; j < len; j++) {
                sum += nums[j];
                preSumMap.put(new Pair(i, j), sum);
            }
        }
    }
    
    // query: O(1)
    public int sumRangeHashMap(int left, int right) {
        return preSumMap.get(new Pair(left, right));
    }
    
    // --- bruteForce ---
    // O(n). O(1)
    public int bruteForce(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */