class Solution {
    
    // "9,3,4,#,#,1,#,#,2,#,6,#,#"             // "9,#,#"
    //. ^                                          ^
    // slots = 1    1 - 1 + 2                   1          1 - 1
    //.( )             (9)                     ( )           (9)
    //       ->       /   \                          ->     /   \
    //              ( )   ( )                             (#)   ( )
    
    // TC: O(n^2). SC: O(n^2)
    public boolean isValidSerialization(String preorder) {
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