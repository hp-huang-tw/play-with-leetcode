class Solution {
    
    // min heap
    // 1. Initialize a heap timeslots and push time slots that last longer than duration into it.
    // 2. Iterate until there's only one time slot remaining in timeslots:
    //   2-1. Pop the first time slot [start1, end1] from timeslots.
    //   2-2. Retrieve the next time slot [start2, end2], which is the current top element in timeslots.
    //.  2-3. If we find end1 >= start2 + duration, because start1 <= start2, 
    //      the common slot is longer than duration and we can return it.
    // 3. If we don't find the common slot that is longer than duration, return an empty array.

    // TC: O((n+m)log(n+m))
    //  popping one element takes O(log(n+m))). in the worst case, popping M + N times 
    
    // SC: O(m+n) for timelots in a heap
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        // keep earliest start time is on top.
        PriorityQueue<int[]> timeslots = new PriorityQueue<>((s1, s2) -> s1[0] - s2[0]);
        
        // only offer timeslot is larger than duration
        for (int[] s: slots1) {
            if (s[1] - s[0] >= duration) {
                timeslots.offer(s);
            }
        }
        
        for (int[] s: slots2) {
            if (s[1] - s[0] >= duration) {
                timeslots.offer(s);
            }
        }
        
        // pick 2 timeslots
        while (timeslots.size() > 1) {
            int[] s1 = timeslots.poll();
            int[] s2 = timeslots.peek();
            
            if (s1[1] >= s2[0] + duration) {
                return new ArrayList<>(Arrays.asList(s2[0], s2[0] + duration));
            }
        }
        
        return new ArrayList<>();
    }
    
    // TC: O(nlog(n)) + O(mlog(m))
    // SC: O(1)
    public List<Integer> twoPointers(int[][] slots1, int[][] slots2, int duration) {
        
        // O(nlog(n)) + O(mlog(m))
        Arrays.sort(slots1, (s1, s2) -> s1[0] - s2[0]);
        Arrays.sort(slots2, (s1, s2) -> s1[0] - s2[0]);
        
        int p1 = 0, p2 = 0;
        
        while (p1 < slots1.length && p2 < slots2.length) {
            
            // find the overlapped period
            int start = Math.max(slots1[p1][0], slots2[p2][0]);
            int end = Math.min(slots1[p1][1], slots2[p2][1]);
            
            // return start, start + duration, if found
            if (end - start >= duration) {
                return new ArrayList<>(Arrays.asList(start, start + duration));
            }
            
            // move pointer which end earlier
            if (slots1[p1][1] < slots2[p2][1]) {
                p1++;
            } else {
                p2++;
            }
            
        }
        
        return new ArrayList<>();
        
    }
}