class Solution {
    
    // TC: O(E+V), SC: O(E+V)
    public boolean validTree(int n, int[][] edges) {
        
        // create graph
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            List<Integer> node1Adj = graph.getOrDefault(node1, new ArrayList<Integer>());
            node1Adj.add(node2);
            graph.put(node1, node1Adj);
                                                   
            List<Integer> node2Adj = graph.getOrDefault(node2, new ArrayList<Integer>());
            node2Adj.add(node1);
            graph.put(node2, node2Adj);
        }
        
        // dfs traverse
        Set<Integer> visited = new HashSet<Integer>();
        boolean isValid = isValidTree(graph, 0, -1, visited);
        
        return isValid && n == visited.size();
    }
    
    private boolean isValidTree(HashMap<Integer, List<Integer>> graph,
                                int curNode, int prevNode, Set<Integer> visited) {
        // isCyclic
        if (visited.contains(curNode)) {
            return false;
        }
        visited.add(curNode);
        
        List<Integer> nodes = graph.getOrDefault(curNode, new ArrayList<Integer>());
        for (int n : nodes) {
            if (n == prevNode) {
                continue;
            }
            if (!isValidTree(graph, n, curNode, visited)) {
                return false;
            }
        }
        
        return true;
    }
}