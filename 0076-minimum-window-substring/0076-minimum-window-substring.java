class Solution {
    // TC: O(m+n), SC: O(m+n)
    public String minWindow(String s, String t) {
        
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        
        for (char c : t.toCharArray()) {
            tMap.put(c, 1 + tMap.getOrDefault(c, 0));
        }
        
        int matchCount = 0;
        String res = "";
        int minLen = Integer.MAX_VALUE;
        
        int l = 0;
        
        for (int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);
            sMap.put(rightChar, 1 + sMap.getOrDefault(rightChar, 0));
            
            if (tMap.containsKey(rightChar) && sMap.get(rightChar) <= tMap.get(rightChar)) {
                matchCount++;
            }
            
            while (matchCount == t.length()) {
                // update minLen
                int len = r - l + 1;
                if (len < minLen) {
                    res = s.substring(l, r + 1);
                    minLen = len;
                }
                 
                char leftChar = s.charAt(l);
                sMap.put(leftChar, sMap.get(leftChar) - 1);
                
                
                if (tMap.containsKey(leftChar) && sMap.getOrDefault(leftChar, 0) < tMap.get(leftChar)) {
                    matchCount--;
                }
                
                l++;
            }
            
        }
        
        return res;
    }
}