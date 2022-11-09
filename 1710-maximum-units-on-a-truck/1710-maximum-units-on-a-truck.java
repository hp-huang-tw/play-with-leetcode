class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        
        int res = 0;
        int complement = truckSize;
        for (int[] box: boxTypes) {
            int numberOfBoxes = box[0];
            int numberOfUnits = box[1];
            
            if (complement == 0) return res;
            
            if (numberOfBoxes <= complement) {
                res += numberOfBoxes * numberOfUnits;
                complement -= numberOfBoxes;
            } else {
                res += complement * numberOfUnits;
                complement = 0;
                
            }
        }
        return res;
    }
}