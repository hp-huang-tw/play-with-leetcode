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
        return coverter(nums, 0, nums.length - 1);  
    }
    
    private TreeNode coverter(int[] nums, int l, int r) {
        if (l > r) return null;
        
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = coverter(nums, l, mid - 1);
        node.right = coverter(nums, mid + 1, r);
        return node;

    }
}


/*

[-10,-3,0,5,9]                 [0]
   l    mid   r

*/


/*

[-10,-3,0,5,9] 

sub-problem: left portion & right portion
-> [-10,-3] ,0  [5,9]                           [0]
     l   r       l  r                          /   \
         mid       mid                      [-3]   [9]
*/



/*

[-10,-3,0,5,9] 
-> [-10,-3] ,0  [5,9]
sub-problem: left portion & right portion
-> [-10] -3 ,0  [5]                         [0]
     lr          lr                        /.  \
     mid        mid                     [-3]   [9]
                                         /     /
                                     [-10]   [5] 
*/



