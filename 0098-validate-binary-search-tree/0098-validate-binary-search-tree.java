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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    // TC: O(n)    
    private boolean isValidBST(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }
        
        if (!(left < node.val && node.val < right)) return false;
        
        return isValidBST(node.left, left, node.val) && isValidBST(node.right, node.val, right);
    }
    
    private boolean inorder(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i -1) ) {
                return false;
            }
        }
        
        return true;
    }
    
    private void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}