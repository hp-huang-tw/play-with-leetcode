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
        if (root == null) return 0; // []
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
            
                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        
        return level;
    }
    
    /*  
        | 3 |           lv++ (1)
         /  \
        9    20     ->  |9, 20|  lv++ (2)
            /   \           / \   
           15    7         15  7        -> |15, 17| lv++ (3)
    */                                              
    
    /*
               1
        null        2
    */
    
    // recursion
    private int longestPath(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(longestPath(root.left), longestPath(root.right));
    }
}