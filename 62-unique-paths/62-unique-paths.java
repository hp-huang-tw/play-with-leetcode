class Solution {
    public int uniquePaths(int m, int n) {
        //m=down, n=right
        //s= 0,0. desitionation= m-1 n-1
        
        int[][] step=new int[m][n];
        
        for(int i=0; i < m; i++) {
            for (int j=0; j<n; j++) {
                if(j==0 || i==0) {
                    step[i][j]=1;
                } else {
                    step[i][j]=step[i][j-1]+step[i-1][j];
                }
            }
        }
        
        return step[m-1][n-1];
    }
}
