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
    public int maxDepth(TreeNode root) {
        return bfs(root);
    }
    
    private int bfs(TreeNode root) {
        if (root==null) return 0;
        int level=0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                TreeNode node = q.remove();
                if (node.left !=null) {
                    q.add(node.left);
                }
                if (node.right !=null) {
                    q.add(node.right);
                }
            }
            level++;
        }
        
        return level;
    }
    
    private int dfs(TreeNode root) {
        if (root==null) return 0;
        return 1+Math.max(dfs(root.left), dfs(root.right));
        
    }
}