class Solution {
    
    public int majorityElement(int[] nums) {
       return boyerMore(nums);
    }
    
    // sort: O(n), O(1)
    public int sort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    // Boyer More Algo: O(n), O(1)
    public int boyerMore(int[] nums) {
        int count = 0;
        int res = 0;
        
        for (int n: nums) {
            if (count == 0) {
                res = n;
            }
            count += (res == n) ? 1: -1;
        }
        
        return res;
    }
    
    // HashMap: O(n), O(n)
    public int hashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int res = 0;
        int maxCount = 0;
        for (int n: nums) {
            int count = 1+map.getOrDefault(n, 0);
            map.put(n, count);
            if (count > maxCount) {
                res = n;
                maxCount = count;
            }
        }
        
        return res;
    }
}