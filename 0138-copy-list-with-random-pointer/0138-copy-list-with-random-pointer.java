/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    HashMap<Node, Node> copiedMap = new HashMap<>();
    
    // copyRandomList
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        if (copiedMap.containsKey(head)) {
            return copiedMap.get(head);
        }
        
        Node node = new Node(head.val);
        copiedMap.put(head, node);
        
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        
        return node;
    }
    
    // TC: O(n), SC: O(n)
    private Node hashcopyRandomList_HashMap(Node head) {
        if (head == null) return null;
        
        Node currNode = head;
        while (currNode != null) {
            Node copiedNode = new Node(currNode.val);
            copiedNode.next = currNode.next;
            copiedNode.random = currNode.random;
            copiedMap.put(currNode, copiedNode);

            currNode = currNode.next;
        }

        for (Map.Entry<Node, Node> nodeEntry : copiedMap.entrySet()) {
            Node copiedNode = nodeEntry.getValue();
            copiedNode.next = copiedMap.get(nodeEntry.getKey().next);
            copiedNode.random = copiedMap.get(nodeEntry.getKey().random);
        }

        return copiedMap.get(head);
    }
}