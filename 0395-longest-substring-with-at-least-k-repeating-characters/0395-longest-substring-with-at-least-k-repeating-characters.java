class Solution {
    
    /*
    recursion
        aaabb   k=3
            a       aa  aaa(v)     aaab(x)    aaabb (x)
            |\
            a ab

        ababbc, k=2
            a                   ab  aba     abab|4  ababb|5     ababbc
          / | \   \     \           / \   \
         b ba bab  babb babbc      b bb|2 bbc
        /|\\------|    
       a ab abb  abbc
       /
      b
    */
    
    /*
    divide & conquer
    abcbaa, k = 2
      
    
    abcbaa, count a:3,b:2,c:1. 
      ^
    // walk through hashMap and find the position of the char which is less than k
    // c < 2. index = 2
    split as 2 subproblem
    ab,     count a:1,b:1       baa  count a:2,b:1       
    ^                           ^
    b,  count b:1                aa  count a:2
    ^                            ^
      
    */
    
    String s;
    
    int k;
        
    // TC: O(n^2)
    // SC: O(n)
    public int longestSubstring(String s, int k) {
        this.s = s;
        this.k = k;
        return helper(0, s.length());
    }
    
    private int helper(int start, int end) {
        // stop condition: if end - start is less than k
        // "ababacb", k=3
        if (end - start < k) return 0;
        
        // built counting map
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            countMap.put(c, 1 + countMap.getOrDefault(c, 0));
        }
        
        for (Character c : countMap.keySet()) {
            if (countMap.get(c) < k) {
                for (int i = start; i < end; i++) {
                    if (s.charAt(i) == c) {
                        int left = helper(start, i);
                        int right = helper(i + 1, end);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }
}