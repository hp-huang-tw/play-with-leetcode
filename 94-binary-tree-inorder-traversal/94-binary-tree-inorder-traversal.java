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
    public List<Integer> inorderTraversal(TreeNode root) {
        // in-order: left -> node -> right
        List<Integer> resultList = new ArrayList<>();
        helper(root, resultList);
        return resultList;
        
    }
    
    private void helper(TreeNode root, List<Integer> resultList) {
        if (root != null) {
            helper(root.left, resultList);
            resultList.add(root.val);
            helper(root.right, resultList);
        }
    }
    
}