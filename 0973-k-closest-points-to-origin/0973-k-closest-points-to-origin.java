class PointsComparator implements Comparator<int[]> {
    
    @Override
    public int compare(int[] a, int[] b) {
        return (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]);
    }
    
} 
    
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new PointsComparator());
        return Arrays.copyOfRange(points, 0, k);
    }
}
