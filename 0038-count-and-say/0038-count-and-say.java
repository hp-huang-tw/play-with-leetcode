class Solution {
    
    // recursive 1 -> n
    // 1 -> 1
    // 2 -> 1       Pair(1, 1)           -> one 1        -> 11
    // 3 -> 11      Pair(1, 2)           -> two 1        -> 21
    // 4 -> 21      Pair(2, 1), (1, 1)   -> one 2 one 1  -> 1211
    // 5 -> 1211    Pair(1, 1), (2, 1) (1, 2) one 1 one 2 two 1 ->   111221
    String res;
    
    public String countAndSay(int n) {
        res = "1";
        for (int i = 1; i < n; i++) {
            res = countAndSayHelper(res);   // if n = 1, not into loop.
        }
        // countAndSayHelper(1, n);
        return res;
    }
    
    // 2) i(1): "1"
    // 3) i(2): "11"
    // 4) i(3): "21"
    private String countAndSayHelper(String s) {
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0); // 2) 1       3) 1        4) 2
        int count = 1;
        
        for (int i = 1; i < s.length(); i++) {    // 2) 1 not into loop   3) 1
            char currChar = s.charAt(i);
            if (currChar == c) {                // 3) counter = 2
                count++;
            } else {
                sb.append(count);              
                sb.append(c);
                // update char & reset counter   // 4) 12
                c = currChar;                    // 4) c = 1, count = 1
                count = 1;
            }
        }
        // append last pair
        sb.append(count);
        sb.append(c);                       // 2) 11        3) 21       4) 1211
        return sb.toString();
    }
    
}