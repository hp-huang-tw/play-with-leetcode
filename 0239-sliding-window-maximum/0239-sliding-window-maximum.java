class Solution {
    // Time complexity is O(1) * O(n) = O(n).
    // For removing and adding elements in deque its O(1)
    // We visit each element once so its O(n).
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length-k+1];
        int l = 0;
        int r = 0;
        int cnt = 0;
        
        Deque<Integer> q = new LinkedList<>();
        while(r < nums.length){
            while(!q.isEmpty() && nums[q.peekLast()] < nums[r])
                q.pollLast();
            q.offer(r);
            if(l > q.peek())
                q.poll();
            if(r+1 >= k){
                arr[cnt++] = nums[q.peek()];
                l += 1;                
            }
            r += 1;
        }
        return arr;
    }
}