enum STATUS {
    UNVISITED,
    VISTING,
    VISITED
}


class Solution {
    
    HashMap<Integer, List<Integer>> prereqMap;
    
    HashMap<Integer, STATUS> visitMap = new HashMap<>();
    
     List<Integer> result = new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create the adjacency list of prerequsites
        prereqMap = new HashMap<>();
        
        // initialize with empty array first
        for (int i=0; i < numCourses; i++) {
            prereqMap.put(i, new ArrayList<>());
        }
        
        for (int[] p: prerequisites) {
            prereqMap.get(p[0]).add(p[1]);
        }
        
        // initilize visit map
        visitMap = new HashMap<>();
        
        for (int i=0; i < numCourses; i++) {
            visitMap.put(i, STATUS.UNVISITED);
        }
        
        // List<Integer> result = new ArrayList<>();
        
        for (int i=0; i < numCourses; i++) {
            if (!dfs(i)) return new int[0];
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // time: O(V+E) i.e. O(p+n)
    // space: O(N)
    private boolean dfs(int course) {
        STATUS visitStatus = visitMap.get(course);
        
        if (visitStatus.equals(STATUS.VISTING)) return false; // cyclic
        if (visitStatus.equals(STATUS.VISITED)) return true;
        
        // mark it as visiting
        visitMap.put(course, STATUS.VISTING);
        for (int p: prereqMap.get(course)) {
            if (!dfs(p)) return false;
        }
        visitMap.put(course, STATUS.VISITED);
        result.add(course);
        
        return true;
    }
}