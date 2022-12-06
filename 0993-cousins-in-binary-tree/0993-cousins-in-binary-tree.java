/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    // BFS
    // TC: O(n), SC: O(n)
    public boolean isCousins(TreeNode root, int x, int y) {
        // root = [1,2,3,null,4,null,5], x = 5, y = 4
        //           1          depth
        //          / \           1       2      3
        //         2.  3         |1|    |2,3|   |4||5|
        //          \   \         
        //           4   5
    
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
    
        int depthY = -1, depthX = -2;
        int level = 1;
        while (!queue.isEmpty()){
            int qSize = queue.size();
            
            for (int i = 0 ; i < qSize ; i++) {
                TreeNode node = queue.remove();
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) || 
                        (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }
                    
                if (node.val == x) depthX = level;
                if (node.val == y) depthY = level;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            
            level++;
        }
        
        return depthX == depthY;
    }
}