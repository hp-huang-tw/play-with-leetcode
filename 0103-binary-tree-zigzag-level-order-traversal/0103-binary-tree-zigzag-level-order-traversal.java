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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {                      // [3]   | [9, 20]
            int qSize = q.size();                   //
            LinkedList<Integer> lists = new LinkedList<>();
                                                    // list
            for (int i = 0; i < qSize; i++) {       // [3] 
                TreeNode node = q.poll();
                
                if (node.left != null) {
                    q.add(node.left);
                }
                
                if (node.right != null) {
                    q.add(node.right);
                }
                
                if (res.size() % 2 == 0) {          // [], [[3], [20, 9]]
                    lists.add(node.val);
                } else {                            // [[3]]
                    lists.addFirst(node.val);
                }
            }
            
            if (!lists.isEmpty()) {
                res.add(new ArrayList<>(lists));
            }
            
        }
        
        return res;
    }
}