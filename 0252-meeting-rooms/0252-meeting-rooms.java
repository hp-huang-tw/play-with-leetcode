class Solution {
    
    // TC: O(nLog(n)), SC: O(1)
    public boolean canAttendMeetings(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) return true;
            
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int prevEnd = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (prevEnd > intervals[i][0]) {
                return false;
            }
            prevEnd = intervals[i][1];
        }
        
        return true;
    }
}