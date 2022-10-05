/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    private HashMap<Node, Node> oldNewMap = new HashMap<Node, Node>();
    
    public Node cloneGraph(Node node) {
        return (node == null) ? null : helper(node);
    }
    
    // time: O(n) -> O(E+V)
    private Node helper(Node node) {
        if (oldNewMap.containsKey(node)) 
            return oldNewMap.get(node);
        
        Node copiedNode = new Node(node.val);
        oldNewMap.put(node, copiedNode);
        
        for (Node neighbor : node.neighbors) {
             copiedNode.neighbors.add(helper(neighbor));
        }
        
        return copiedNode;
    }
}