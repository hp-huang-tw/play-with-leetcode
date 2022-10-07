class Solution {
    
    // heap: O(n long(n))
    // time: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numCountMap = new HashMap<Integer, Integer>();
        
        for (int num : nums) {
            numCountMap.put(num, 1 + numCountMap.getOrDefault(num, 0));
        }
        
        
        HashMap<Integer, List<Integer>> freqMap = new HashMap<Integer, List<Integer>>();
        for (int num: numCountMap.keySet()) {
            Integer count = numCountMap.get(num);
            List<Integer> numList = freqMap.getOrDefault(count, new ArrayList<Integer>());
            numList.add(num);
            freqMap.put(count, numList);
        }
        
        int[] res = new int[k];
        int j = 0;
        for (int i = nums.length; i > -1; i--) {
            if (freqMap.containsKey(i)) {
                for (int num :freqMap.get(i)) {
                    res[j] = num;
                    j++;
                    if (j==k) return res;
                }   
            }
        }
        
        return res;
    }
}