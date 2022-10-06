class Node {
    
    public int key;
    
    public int value;
    
    public Node prev;
    
    public Node next;
    
    public Node (int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    
    private int capacity;
    
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    
    private Node leastRecentUsed = new Node(0,0);
    
    private Node mostRecentUsed = new Node(0,0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        leastRecentUsed.next = mostRecentUsed;
        mostRecentUsed.prev = leastRecentUsed;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // moveToRight = remove then insert
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {      
        // if exist same key
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        
        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);
        
        // remove from lruNode list and amp if the nums of keys is exceeded
        if (map.size() > capacity) {
            Node lruNode = leastRecentUsed.next;
            remove(lruNode);
            map.remove(lruNode.key);
        }
    }
    
    // remove from list
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    // insert the node to the right
    private void insert(Node node) {
        Node nodePrev = mostRecentUsed.prev;
        Node nodeNext = mostRecentUsed;
        
        nodePrev.next = node;
        nodeNext.prev = node;   
        node.prev = nodePrev;
        node.next = nodeNext;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */