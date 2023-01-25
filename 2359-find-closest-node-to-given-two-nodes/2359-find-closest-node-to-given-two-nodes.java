class Solution {
    
    // TC: O(n)
    // SC: O(n)
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        
        calcDistance(edges, node1, dist1);
        calcDistance(edges, node2, dist2);
        
        int res = Integer.MAX_VALUE;
        int node = -1;
        
        for (int i = 0; i < n; i++) {
            if (dist1[i] == -1 || dist2[i] == -1) continue;
            int max = Math.max(dist1[i], dist2[i]);
            if (res > max) {
                res = max;
                node = i;
            }
        }
        
        return node;
        
    }
    
    private void calcDistance(int[] edges, int node, int[] dist) {
        Arrays.fill(dist, -1);
        
        Deque<Integer> q = new LinkedList<>();
        q.add(node);
        dist[node] = 0;
        
        while (!q.isEmpty()) {
            int curr = q.pollFirst();
            int next = edges[curr];
            
            if (next != -1 && dist[next] == -1) {
                q.add(next);
                dist[next] = dist[curr] + 1;
            }
        }
    }
}