/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // DFS: pre-order traverse
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        serializeHelper(root, res);
        String ans = String.join(",", res);
        //System.out.println(ans);
        return ans;
    }
    
    // input: TreeNode(1) 
    //               |----- TreeNode(2)
    //               |----- TreeNode(3)
    //                             |----- TreeNode(4)
    //                             |----- TreeNode(5)
    // string: 1, 2, null, null, 3, 4, null, null, 5, null, null
    private void serializeHelper(TreeNode root, List<String> res) {
        if (root == null) {
            res.add("null");
            return;
        }
        
        res.add(String.valueOf(root.val));
        serializeHelper(root.left, res);
        serializeHelper(root.right, res);
    }

    // Decodes your encoded data to tree.
    // input: 1, 2, null, null, 3, 4, null, null, 5, null, null
    // output: 
    //      TreeNode(1) 
    //               |----- TreeNode(2)
    //               |----- TreeNode(3)
    //                             |----- TreeNode(4)
    //                             |----- TreeNode(5)
    public TreeNode deserialize(String data) {
        //System.out.println(data);
        List<String> dataList = new ArrayList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(dataList);
    }
    
    int index = 0;
    private TreeNode deserializeHelper(List<String> dataList) {
        String currData = dataList.get(index);
        if (currData.equals("null")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(currData));
        index++;
        root.left = deserializeHelper(dataList);
        root.right = deserializeHelper(dataList);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));