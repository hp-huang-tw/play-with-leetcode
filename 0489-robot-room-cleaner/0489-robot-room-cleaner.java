/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    
    // Explore 4 directions : 
    // up, right, down, and left (the order is important since the idea is always to turn right) :
    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    
    Set<Pair<Integer, Integer>> visited = new HashSet();
    
    Robot robot;
    
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }
    
    public void backtrack(int row, int col, int dir) {
        visited.add(new Pair(row, col));
        robot.clean();
        
        // move clockwise(up->right->down->left)
        for (int i = 0; i < 4; i++) {
            int nextDir = (dir + i) % 4;
            
            int nextRow = row + directions[nextDir][0];
            int nextCol = col + directions[nextDir][1];
            
            // not visit & can move
            if (!visited.contains(new Pair(nextRow, nextCol)) && robot.move()) {
                backtrack(nextRow, nextCol, nextDir);
                goBack();
            }
            
            // turn the robot following chosen direction : clockwise
            robot.turnRight();
        }
    }
    
    // Go back to that cell and then turn right from your last explored direction.
    private void goBack() {
        // go back prev position
        robot.turnRight();
        robot.turnRight();
        robot.move();
        
        // turn to original direction
        robot.turnRight();
        robot.turnRight();
    }
    
}