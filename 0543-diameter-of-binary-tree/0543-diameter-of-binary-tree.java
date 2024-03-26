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

    private int[] getLongestPathAndDiameter(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        
        int[] longestLeft = getLongestPathAndDiameter(root.left);
        int[] longestRight = getLongestPathAndDiameter(root.right);
        int diameterPass = longestLeft[0] + longestRight[0];
        int diameterNotPassRoot = Math.max(longestLeft[1], longestRight[1]);
        int diameter = Math.max(diameterPass, diameterNotPassRoot);
        return new int[] { 1 + Math.max(longestLeft[0], longestRight[0]), diameter };
    }
}