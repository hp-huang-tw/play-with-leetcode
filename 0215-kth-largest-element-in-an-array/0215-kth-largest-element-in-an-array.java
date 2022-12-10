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
    
    // 3  2  1  6  5  4          // 3 2 1  6 5 4
    // lp             r                   |
    // p->                                 p.  pv   --> 3 2 1 | 4 5 6
    // i
    //              pivot                 
    private int quickSelectHelper(int leftMost, int rightMost) {
        int pivot = nums[rightMost], p = leftMost;
        for (int i = leftMost; i < rightMost; i++) {
            if (nums[i] <= pivot) { // swap itself handle right portion
                swap(p, i);
                //System.out.format("swap(%d, %d)\n", p, i);
               // System.out.println(Arrays.toString(nums));
                p++;
            }
        }
        
        swap(p, rightMost); // swap pivot with p of value
       // System.out.format("swap(%d, %d)\n", p, rightMost);
        //System.out.println(Arrays.toString(nums));
        
        if (p > indexK) return quickSelectHelper(leftMost, p - 1);
        else if (p < indexK) return quickSelectHelper(p + 1, rightMost);
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