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
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            // traverse left-tree and push node into stack
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // already leftmost, pop node in the stack
            curr = stack.pop();
            res.add(curr.val);

            // traverse its right-tree push
            curr = curr.right;

        }
        return res;
        
    }
}