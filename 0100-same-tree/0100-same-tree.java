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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!isSame(p, q)) return false;
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        
        q1.offer(p);
        q2.offer(q);
        
        while (!q1.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            
            if (!isSame(node1, node2)) return false;
            
            if (node1 != null) {
                if (!isSame(node1.left, node2.left)) return false;
                if (node1.left != null) {
                    q1.offer(node1.left);
                    q2.offer(node2.left);
                }
                
                if (!isSame(node1.right, node2.right)) return false;
                if (p.right != null) {
                    q1.offer(node1.right);
                    q2.offer(node2.right);
                }
            }
        }
        
        return true;
    }
    
    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p != null && q == null) || (p == null && q != null)) return false;
        if (p.val != q.val) return false;
        return true;
    }
}