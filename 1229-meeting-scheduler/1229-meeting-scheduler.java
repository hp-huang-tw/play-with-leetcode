class Solution {
    
    // TC: O(nlog(n)) + O(mlog(m))
    // SC: O(1)
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        
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