class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> newIntervals = new ArrayList<int[]>();
        
        for (int[] interval: intervals) {            
            if (newIntervals.isEmpty() || interval[0] > newIntervals.get(newIntervals.size() - 1)[1]) {
                newIntervals.add(interval);
            }
            else {
                int[] lastInterval = newIntervals.get(newIntervals.size() - 1);
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
                newIntervals.set(newIntervals.size() - 1, lastInterval);
            }
        }
        
        return newIntervals.toArray(new int[0][]);
    }
}