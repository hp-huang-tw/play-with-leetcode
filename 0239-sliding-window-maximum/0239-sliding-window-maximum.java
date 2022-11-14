class Solution {
    // Time complexity is O(1) * O(n) = O(n).
    // For removing and adding elements in deque its O(1)
    // We visit each element once so its O(n).
    
    // monotonic queue
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1]; // index
        // List<Integer> resList = new ArrayList<>();
        
        int l = 0, r = 0, curr = 0;
        
        Deque<Integer> q = new LinkedList<>();
        
        while (r < nums.length) {
            // we need to pop smaller values from q at first before appending r.
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }
            q.offer(r);
            
            // remove left most from queue
            if (l > q.peek()) {
                q.poll();
            }
            
            // start to ouput if r + 1 = k
            if (r + 1 >= k) {
                // resList.add(nums[q.peek()]);
                res[curr++] = nums[q.peek()];
                l++;
            }
            
            r++;
        }
        return res;
        
        // return resList.stream().mapToInt(Interger::intValue).toArray();
    }
}