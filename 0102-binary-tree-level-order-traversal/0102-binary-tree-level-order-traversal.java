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
    // bfs: 
    // TC: O(n), SP: O(n/2) -> O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
       
        while (!q.isEmpty()) {
            int qSize = q.size();
            List<Integer> nodes = new ArrayList<>();
            
            // get all node in the queue
            for (int i = 0; i < qSize; i++) {          
                TreeNode node = q.pollFirst();
                if (node != null) {
                    nodes.add(node.val);

                    q.add(node.left);
                    q.add(node.right);
                } 
            }
            
            if (!nodes.isEmpty()) {
                res.add(nodes);
            }
        }
        
        return res;
    }
        
}