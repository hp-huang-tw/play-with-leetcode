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
class TreeState {
	public final boolean isBalanced;
	public final int height;

	public TreeState (boolean isBalanced, int height) {
		this.isBalanced = isBalanced;
		this.height = height;
	}

    public int getHeight () {
        return this.height;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
	    TreeState rootState = getHeightAndBalance(root);
	    return rootState.isBalanced;
    }
    
    private TreeState getHeightAndBalance(TreeNode root) {
		// Base case - height of the subtree is 0
        if (root == null) return new TreeState(true, 0);
        
        TreeState leftState = getHeightAndBalance(root.left);
        TreeState rightState = getHeightAndBalance(root.right);
        
        boolean isBalanced = leftState.isBalanced && rightState.isBalanced &&
	        Math.abs(leftState.getHeight() - rightState.getHeight()) < 2;
	      
	      int height = 1 + Math.max(leftState.getHeight(), rightState.getHeight());
	      
	      return new TreeState(isBalanced, height);
    }
}