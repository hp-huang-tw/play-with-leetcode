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
    int camera = 0;
    
    // ineorder
    // TC: O(n)
    // SC: O(H) -> O(n) if it's 'skewed tree
    public int minCameraCover(TreeNode root) {
        // If root is not covered then we need to place a camera at root node
        // e.g. [0, null, null] or skewed tree [0,0,null,0,null,0]
        return installCamera(root) == CAMERA_STATUS.UNCOVERED ? camera + 1 : camera;
    }
    
    public enum CAMERA_STATUS { HAS_CAMERA, COVERED, UNCOVERED };
    
    public CAMERA_STATUS installCamera(TreeNode root) {
        
        // Base case - if there is no node then it's already covered
        if (root == null)
            return CAMERA_STATUS.COVERED;
        
        // Try to cover left and right children's subtree
        CAMERA_STATUS l = installCamera(root.left);
        CAMERA_STATUS r = installCamera(root.right);
        
        // If Any one of the children is not covered then we must place a camera at current node
        if (l ==  CAMERA_STATUS.UNCOVERED || r == CAMERA_STATUS.UNCOVERED) {
            camera++;
            return CAMERA_STATUS.HAS_CAMERA;
        }
        
        // If any one of left or right node has Camera then the current node is also covered
        if (l == CAMERA_STATUS.HAS_CAMERA || r == CAMERA_STATUS.HAS_CAMERA) 
            return CAMERA_STATUS.COVERED;
        
        // If None of the children is covering the current node then ask it's parent to cover
        return CAMERA_STATUS.UNCOVERED;
    }
}