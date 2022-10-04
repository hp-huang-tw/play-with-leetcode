class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create adjacency map
        HashMap<Integer, List<Integer>> courseMap = new HashMap<Integer, List<Integer>>();
        
        // intialize map with empty array list
        for (int i=0; i < numCourses; i++) {
            courseMap.put(i, new ArrayList<Integer>());
        }
        
        for (int[] p: prerequisites) {
            courseMap.get(p[0]).add(p[1]);
        }
        
        // create visited logger
        HashSet<Integer> visitedSet = new HashSet<>();
        
        // iterate all courses
        for (int i=0; i < numCourses; i++) {
            if (!dfs(i, courseMap,visitedSet)) return false;
        }
        
        return true;
    }
    
    private boolean dfs(int course, HashMap<Integer, List<Integer>> courseMap, 
                        HashSet<Integer> visitedSet) {
        if (visitedSet.contains(course)) 
            return false;
        if (courseMap.get(course).isEmpty()) 
            return true;
        
        visitedSet.add(course);
        for (int crs: courseMap.get(course)) {
            if (!dfs(crs, courseMap, visitedSet)) return false;
        }
        visitedSet.remove(course);
        courseMap.get(course).clear();
        
        return true;
    }
}