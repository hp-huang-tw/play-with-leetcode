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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<String>();
        serializeHelper(root, res);
        return String.join(",", res);
    }
    
    private void serializeHelper(TreeNode root, List<String> res) {
        if (root == null) {
            res.add("N");
            return;
        }
        
        res.add(String.valueOf(root.val));
        serializeHelper(root.left, res);
        serializeHelper(root.right, res);
    }
    
   
    // Decodes your encoded data to tree.
    private int index = 0;
    public TreeNode deserialize(String data) {
        List<String> dataList = new ArrayList<String>(Arrays.asList(data.split(",")));
        return deserializeHelper(dataList);
    }
    
    private TreeNode deserializeHelper(List<String> dataList) {
        String s = dataList.get(index);
        if (s.equals("N")) {
            index++;
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(s));
            index++;
            node.left = deserializeHelper(dataList);
            node.right = deserializeHelper(dataList);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;