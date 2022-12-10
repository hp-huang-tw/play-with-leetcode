class Solution {
    public int findKthLargest(int[] nums, int k) {
        return minMeap(nums, k);
    }
    
    // sort is O(nLog(n))
    // TC: O(nLog(k)), SC: O(k)
    private int minMeap(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        
        for (int n : nums) {
            heap.add(n); // nums [3, 1, 2, 1] k = 2.    [1, 3] -> [1, 2, 3] -> [2, 3]
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        return heap.poll();
    }
}