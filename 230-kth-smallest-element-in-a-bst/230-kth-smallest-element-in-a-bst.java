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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> resultList = new ArrayList<>();
        inorder(root, resultList);
        return resultList.get(k-1);
        
    }
    
    // resusion inorder
    private void inorder(TreeNode root, List<Integer> resultList) {
        if (root != null) {
            inorder(root.left, resultList);
            resultList.add(root.val);
            inorder(root.right, resultList);
        }
    }
}