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
    public int diameterOfBinaryTree(TreeNode root) {
	    return getLongestPathAndDiameter(root)[1];
    }
    
    private int[] getLongestPathAndDiameter(TreeNode root){
		   if (root == null) return new int[] {0, 0};
		   
		   int[] l = getLongestPathAndDiameter(root.left);
		   int[] r = getLongestPathAndDiameter(root.right);
		   
		   int diameterPassRoot = l[0] + r[0];
		   int maxDiameterNotPassRoot = Math.max(l[1] , r[1]);
		   int diameter = Math.max(diameterPassRoot, maxDiameterNotPassRoot);
		   
		   return new int[] {1 + Math.max(l[0], r[0]), diameter};
    }
}