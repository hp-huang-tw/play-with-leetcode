class Solution {
    
    // "9,3,4,#,#,1,#,#,2,#,6,#,#"             // "9,#,#"
    //. ^                                          ^
    // slots = 1    1 - 1 + 2                   1          1 - 1
    //.( )             (9)                     ( )           (9)
    //       ->       /   \                          ->     /   \
    //              ( )   ( )                             (#)   ( )
    
    // iterate string
    // // TC: O(n). SC: O(1)
    public boolean isValidSerialization(String preorder) {
        int strLen = preorder.length();
        
        int slots = 1;
        for (int i = 1; i < strLen; i++) {
            char curr = preorder.charAt(i);
            
            if (curr == ',') {
                slots--;
                
                if (slots < 0) return false;
                
                if (preorder.charAt(i - 1) != '#') slots += 2;
            }
        }
        
        // handle last node since the no ',' after it.
        slots += (preorder.charAt(strLen - 1) == '#') ? -1 : 1;
        
        return slots == 0;
    }
    
    // iterate nodes
    // TC: O(n). SC: O(n)
    public boolean loopNodes(String preorder) {
        String[] nodes = preorder.split(",");
        
        int slots = 1;
        for (String node : nodes) {                                      // slots
            slots--;                     //    (1)       // case:  1,#,#,1   
                                         //    / \                     ^      0 
            if (slots < 0) return false; // (#)   (#)                    ^.  -1    return false early      
            
            if (!node.equals("#")) {
                slots += 2;
            }
        }
        return slots == 0;
    }
}