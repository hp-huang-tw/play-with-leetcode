class Solution {
    
    // TC: O(n). SC: O(k)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        
        if (n * k == 0) return 0; // strLen or k == 0
        
        // "eceba"        "eceba"               "eceba"             "eceba"
        //. l              l                     l                   l
        //  r               r                      r                    r
        // (e, 0)         (e, 0), (c, 1)        (e, 2), (c, 1)       (e, 2), (c, 1), (b, 3)
        //                                                         -> remove minIndx in map. 
                                                                // leftmost if size is too large
        // "eceba"                "eceba"
        //.   l                      l
        //.    r                       r
        // (e, 2), (b, 3)       (e, 2), (b, 3), (a, 4)
        
        int maxLen = 1;
        Map<Character, Integer> rightMostPosition = new HashMap<>();
        
        int l = 0, r = 0;
        while (r < n) {
            char cur = s.charAt(r);
            rightMostPosition.put(cur, r);
            
            if (rightMostPosition.size() > k) {
                int leftMostIndex = Collections.min(rightMostPosition.values());
                rightMostPosition.remove(s.charAt(leftMostIndex));
                l = leftMostIndex + 1;
            }
            
            maxLen = Math.max(maxLen, (r - l) + 1);
            r++;
        }
        
        return maxLen;
    }
}