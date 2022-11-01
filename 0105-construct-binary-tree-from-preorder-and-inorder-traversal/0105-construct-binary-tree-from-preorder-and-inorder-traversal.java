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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 ||  inorder.length == 0) {
            return null;
        }
        
        // '3, 9, 20, 15, 7'
        // '9, 3, 15, 20, 7'
        
        TreeNode root = new TreeNode(preorder[0]);
        //if(preorder.length==1) return root;
       // int mid = Arrays.asList(inorder).indexOf(preorder[0]);
        int mid = -1;
	    for(int i=0;i<inorder.length;i++) { 
            if(inorder[i]==preorder[0]) { 
                mid=i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), 
                              Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                               Arrays.copyOfRange(inorder, mid + 1, inorder.length));
        
        return root;
    }
}