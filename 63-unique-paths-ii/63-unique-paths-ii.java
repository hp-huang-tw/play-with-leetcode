class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        // first is obstacle
        if (obstacleGrid[0][0]==1) {
            return 0;
        }
        
        obstacleGrid[0][0]=1;
        
        // fill first cols
        for (int i = 1; i < row; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i-1][0]==1 &&  obstacleGrid[i][0]==0) ? 1:0;
        }
        
        // fill first rows
        for (int i = 1; i < col; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i-1]==1 &&  obstacleGrid[0][i]==0) ? 1:0;
        }
        

        for(int i=1; i< row; i++){
            for(int j=1; j< col; j++) {
                if (obstacleGrid[i][j]==0) {
                    obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                } else {
                    obstacleGrid[i][j]=0;
                }
            }
        }
        
        return obstacleGrid[row-1][col-1];
        
    }
        
}