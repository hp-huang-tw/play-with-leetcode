class Solution {
    
    int[] nums;
    
    int indexK;
    
    public int findKthLargest(int[] nums, int k) {
        // return minMeap(nums, k);
        this.nums = nums;
        int len = nums.length;
        indexK = len - k;
        return quickSelectHelper(0, len -1);
    }
    
    // 1 3 2 6 5 4
    // l         r
    //          pivot
    private int quickSelectHelper(int l, int r) {
        int pivot = nums[r], p = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(p, i);
                p++;
            }
        }
        swap(p, r);
        
        if (p > indexK) return quickSelectHelper(l, p - 1);
        else if (p < indexK) return quickSelectHelper(p + 1, r);
        else return nums[p];
    }
    
    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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