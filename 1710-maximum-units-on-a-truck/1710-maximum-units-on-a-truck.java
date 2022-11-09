class Solution {
    // TC: O(nlog(n)), SC: O(1)
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        //Arrays.sort(boxTypes, Comparator.comparingInt(o -> -o[1]));
        
        int res = 0;
        int complement = truckSize;
        for (int[] box: boxTypes) {
            int numberOfBoxes = box[0];
            int numberOfUnits = box[1];
            
            if (complement == 0) return res;
            
            int minNumber = Math.min(numberOfBoxes, complement);
            res +=  minNumber * numberOfUnits;
            complement -= minNumber;

            /*
            if (numberOfBoxes <= complement) {
                res += numberOfBoxes * numberOfUnits;
                complement -= numberOfBoxes;
            } else {
                res += complement * numberOfUnits;
                complement = 0;
            }
            */
        }
        return res;
    }
}