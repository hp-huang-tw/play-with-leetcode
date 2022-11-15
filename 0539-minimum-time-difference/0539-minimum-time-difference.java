class Solution {
    public int findMinDifference(List<String> timePoints) {
       return coutingSort(timePoints);
    }
    
    private int coutingSort(List<String> timePoints) {
        int n = timePoints.size();
        boolean[] buckets = new boolean[24*60];
        
        for (String time: timePoints) {
            int minutes = transform(time);
            if (buckets[minutes]) { // list has same time return diff = 0
                return 0;
            }
            buckets[minutes] = true;
        }
        
        // find first and rev. then diff them
        int first = -1, prev = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i]) {
                if (first == -1) {
                    first = i;
                } else {
                    min = Math.min(min, i - prev);
                }
                prev = i;
            }
        }
        
        // diff first-last
        min = Math.min(min, first - prev + 24*60);
        
        return min;
    }
    
    // TC: O(nlog(n))
    // SC: O(n)
    private int generalSort(List<String> timePoints) {
         List<Integer> minutes = new ArrayList<>();
        
        for (String time: timePoints) {
            minutes.add(transform(time));
        }
        
        Collections.sort(minutes);
        int min = minutes.get(0) - minutes.get(minutes.size() - 1) + 24 * 60;
        
        for (int i = 1; i < minutes.size(); i++) {
            min = Math.min(min, minutes.get(i) - minutes.get(i - 1));    
        }
        
        return min;
    }
    
    
    private int transform(String time) {
        String[] timeArray = time.split(":");
        
        int hour = Integer.parseInt(timeArray[0]);
        int minutes = Integer.parseInt(timeArray[1]);
        return hour * 60 + minutes;
    }
}