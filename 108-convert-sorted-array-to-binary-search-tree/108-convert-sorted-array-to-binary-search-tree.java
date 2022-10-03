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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length-1, nums);
    }
    
    private TreeNode helper(int left, int right, int[] nums) {
        if (left>right) return null;
        
        int mid = (left+right)/2;
        
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(left, mid-1, nums);
        node.right = helper(mid+1, right, nums);
        
        return node;
    }
}