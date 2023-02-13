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
    /*  
             10         left = [7...10], right = [10...15]
            /  \
           5    15
          / \     \
         3   7    18
        low = 7, high = 15
        sum = 7 + 10 + 15
        
        q
        10          if node.val >= low && <= high, sum += node.val
        5  15   
        15  7       if node.val > low ,  push left e.g. 5
        7           if node.val < high,  push right e.g. 15
    */
    
    // BFS
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            int val = node.val;
            if (val >= low && val <= high) {
                sum += val;
            }
            if (val > low && node.left != null) {
                q.offer(node.left);
            }
            if (val < high && node.right != null) {
                q.offer(node.right);
            }
        }
        
        return sum;
    }
    
    public int rangeSumBST_stack(TreeNode root, int low, int high) {
        int res = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (low <= node.val && node.val <= high)
                    res += node.val;
                if (low < node.val)
                    stack.push(node.left);
                if (node.val < high)
                    stack.push(node.right);
            }
        }
        return res;
    }
    
    int res;
    
    public int rangeSumBST_dfs(TreeNode root, int low, int high) {
        res = 0;
        dfs(root, low, high);
        return res;
    }

    public void dfs(TreeNode node, int low, int high) {
        if (node != null) {
            if (low <= node.val && node.val <= high)
                res += node.val;
            if (low < node.val)
                dfs(node.left, low, high);
            if (node.val < high)
                dfs(node.right, low, high);
        }
    }
}