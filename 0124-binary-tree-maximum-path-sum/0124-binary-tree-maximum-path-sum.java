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
    //        1               2->1->3->5 = 11
    //       / \
    //      2.  3             4->3->5 = 12 (max)
    //         / \
    //        4   5
    
    int res;
    
    // TC: O(n)
    // SC: O(n)
    // We don't use any auxiliary data structure, 
    // but the recursive call stack can go as deep as the tree's height. 
    // In the worst case, the tree is a linked list, so the height is nn. 
    // Therefore, the space complexity is O(n)
    public int maxPathSum(TreeNode root) {
        res = root.val;
        dfs(root);
        return res;
    }
    
    // post order traversal of subtree rooted at `root`
    // calc sub-left, sub-right
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // add the path sum from left subtree. Note that if the path
        // sum is negative, we can ignore it, or count it as 0.
        // This is the reason we use `Math.max` here.
        int leftMax = Math.max(0, dfs(root.left));
        
         // add the path sum from right subtree. 0 if negative
        int rightMax = Math.max(0, dfs(root.right));
        
        // max path with split
        // if left or right path sum are negative, they are counted
        // as 0, so this statement takes care of all four scenarios
        res = Math.max(res, root.val + leftMax + rightMax);
                
        return root.val + Math.max(leftMax, rightMax);
    }
    
    
     //       1               2->1->3 = 6
    //       / \
    //      2.  3             
    //         / \
    //       -1  -5           both of sub children is negitive. not take it.
}