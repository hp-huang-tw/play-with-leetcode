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
        return recursiveDfs(root);
    }
    
    private int iterativeDfs(TreeNode root) {
        if (root==null) return 0;
        int maxDepth = 0;
        
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();
            if (node.left!=null) {
                stack.push(new Pair(node.left, depth+1));
            }
            
            if (node.right!=null) {
                stack.push(new Pair(node.right, depth+1));
            }
            maxDepth = Math.max(maxDepth, depth);
        }
        
        return maxDepth;
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
    
    private int recursiveDfs(TreeNode root) {
        if (root==null) return 0;
        return 1+Math.max(recursiveDfs(root.left),
                          recursiveDfs(root.right));
    }
}