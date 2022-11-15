class Solution {
    public int findMinDifference(List<String> timePoints) {
       return generalSort(timePoints);
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