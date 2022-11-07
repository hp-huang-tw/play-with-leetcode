class Solution {
    private int[] parent;
    private int[] size;
            
    // union-find with path compression and union by size
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n]; // size of component
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        int componentCount = n;
        
        for (int[] edge: edges) {
            componentCount -= union(edge[0], edge[1]);
        }
        
        return componentCount;
    }
    
    private int findParent(int node) {
        if (node == parent[node]) return node;
        parent[node] = findParent(parent[node]);
        return parent[node];
    }
    
    // merge two components
    private int union(int node1, int node2) {
        int p1 = findParent(node1);
        int p2 = findParent(node2);
        
        if (p1 == p2) {
            return 0;
        }
        
        if (size[p1] < size[p2]) { // merge small size to large size
            parent[p1] = p2;
            size[p2] += size[p1];
        } else {
            parent[p2] = p1;
            size[p1] += size[p2];
        }
        return 1;
    }
}