class Solution {
    
    // heap: O(n long(n))
    // time: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        return minHeap(nums, k);
    }
    
    
    private int[] minHeap(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        
        HashMap<Integer, Integer> numCountMap = new HashMap<>();
        
        for (int num : nums) {
            numCountMap.put(num, 1 + numCountMap.getOrDefault(num, 0));
        }
        
        // ascending order
        PriorityQueue<Integer> q = new PriorityQueue<>(
            (n1, n2) -> numCountMap.get(n1) - numCountMap.get(n2));
        
        for (int n: numCountMap.keySet()) {
            q.add(n);
            
            if (q.size() > k) {
                q.poll();
            }
        }
        
        int[] res = new int[k];
        
        for (int i = k; i > 0; i--) {
            res[i-1] = q.poll();
        }
        
        return res;
    }
    
    private int[] hashMapAsHeap(int[] nums, int k) {
        HashMap<Integer, Integer> numCountMap = new HashMap<>();
        
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