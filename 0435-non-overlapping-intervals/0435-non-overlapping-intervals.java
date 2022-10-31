class Solution {
    // TC: O(nlogn). 
    // sort by start time O(nlogn)
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int res = 0;
        int prevEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) { // non-overlap
                prevEnd = intervals[i][1];
            } else {
                res++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            }            
        }
        
        return res;
    }
}