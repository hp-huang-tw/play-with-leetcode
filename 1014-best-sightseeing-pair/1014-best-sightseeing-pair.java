class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int maxScore=0;
        int n = values.length;
        
        // O(n^2)
        /*
        for (int i=0; i < n -1 ; i++) {
            for(int j = i+1; j < n; j++) {
                maxScore=Math.max(maxScore, values[i] + values[j] + (i-j));
            }
        }
        */
        
        // [8,1,5,2,6]
        // ithScore=7-1(6), 7-1(6)   
        // maxScore=   7,    11  
        // O(n), O(1)
        int ithScore=values[0];
        
        for (int j=1; j < n; j++) {
            ithScore-=1;
            
            maxScore=Math.max(maxScore, ithScore + values[j]);
            ithScore=Math.max(ithScore, values[j]); // hold max value of arrary
        }
        
        return maxScore;
    }
}
