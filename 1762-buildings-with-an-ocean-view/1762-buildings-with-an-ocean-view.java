class Solution {
    
    // naive solution O(n^2)
    // 2 for-loop to check whether current building is largest one.
    
    //                        // canSeeBuildings, maxHeight
    // heights = [4,2,3,1]    // 
    //                  ^     // [],                -1
    //                ^       // [3],                1
    //              ^         // [3, 2],             3
    //            ^           // [3, 2],             3
    //          ^             // [3, 2, 1],          4
    // then reverse canSeeBuildings
    
    // TC: O(n)
    // SC: O(n)
    public int[] findBuildings(int[] heights) {
        int maxHight = -1;
        
        // store index
        List<Integer> canSeeBuildings = new ArrayList<>();
        
        for (int i = heights.length - 1; i > -1; i--) {
            int currHight = heights[i];
            if (currHight > maxHight) {
                canSeeBuildings.add(i);
                maxHight = currHight;
            }
        }
        
        // reverse index
        /*
        Collections.reverse(canSeeBuildings);
        return canSeeBuildings.stream().mapToInt(Integer::intValue).toArray();
        */
        int canSeeBuildingsSize = canSeeBuildings.size();
        int[] res = new int[canSeeBuildingsSize]; 
        for (int i = 0; i < canSeeBuildingsSize; i++) {
            res[i] = canSeeBuildings.get(canSeeBuildingsSize -1 -i);
        }
        return res;
    }
}