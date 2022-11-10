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
    
    // Space optimization
    // TC: O(n), SC: O(1)
    public Node copyRandomList(Node head) {

        if (head == null) {
          return null;
        }

        // Creating a new weaved list of original and copied nodes.
        Node ptr = head;
        while (ptr != null) {

          // Cloned node
          Node newNode = new Node(ptr.val);

          // Inserting the cloned node just next to the original node.
          // If A->B->C is the original linked list,
          // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
          newNode.next = ptr.next;
          ptr.next = newNode;
          ptr = newNode.next;
        }

        ptr = head;

        // Now link the random pointers of the new nodes created.
        // Iterate the newly created list and use the original nodes' random pointers,
        // to assign references to random pointers for cloned nodes.
        while (ptr != null) {
          ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
          ptr = ptr.next.next;
        }

        // Unweave the linked list to get back the original linked list and the cloned list.
        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        Node ptr_old_list = head; // A->B->C
        Node ptr_new_list = head.next; // A'->B'->C'
        Node head_old = head.next;
        while (ptr_old_list != null) {
          ptr_old_list.next = ptr_old_list.next.next;
          ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
          ptr_old_list = ptr_old_list.next;
          ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }
    
    // copyRandomList
    public Node copyRandomList_recursive(Node head) {
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