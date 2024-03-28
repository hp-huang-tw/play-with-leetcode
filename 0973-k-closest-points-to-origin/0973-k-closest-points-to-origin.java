class PointsComparator implements Comparator<int[]> {
    
    @Override
    public int compare(int[] a, int[] b) {
        return  (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]); // descending
    }
    
} 
    
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new PointsComparator());
        
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll(); // remove in front of element (max)
            }
        }
        
        int[][] res = new int[k][2];
        
        int i = k;
        while (i > 0) {
            res[--i] = pq.poll();
        }
        
        return res;
    }
}
