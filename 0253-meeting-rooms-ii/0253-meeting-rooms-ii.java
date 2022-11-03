class Solution {
    // TC: O(nlog(n)), OC: O(n)
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];
        
        for (int i = 0; i < len; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int count = 0, maxRoom = 0;
        int startIndex = 0, endIndex = 0;
        while (startIndex < len) {
            if (start[startIndex] < end[endIndex]) {
                startIndex++;
                count++;
            } else {
                endIndex++;
                count--;
            }
            
            maxRoom = Math.max(maxRoom, count);
        }
        
        return maxRoom;
    }
}