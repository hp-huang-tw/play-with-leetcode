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
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode rootleft, TreeNode rootRight) {
        if (rootleft == null && rootRight == null) {
            return true;
        }
        
        if (rootleft == null || rootRight == null) {
            return false;
        }
        
        // !null !null
        if (rootleft.val !=rootRight.val) {
            return false;
        }
        
        if (!isSymmetric(rootleft.left, rootRight.right)) {
            return false;
        }
        
        if (!isSymmetric(rootleft.right, rootRight.left)) {
            return false;
        }
        
        return true;
    }
}