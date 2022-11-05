class Solution {
    // TC: O(m+n), SC: O(m+n)
    public String minWindow(String s, String t) {
        
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        
        for (char c : t.toCharArray()) {
            tMap.put(c, 1 + tMap.getOrDefault(c, 0));
        }
        
        int matchCount = 0, needCount = tMap.size();
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
                 
                // pop from the left of our windows
                char leftChar = s.charAt(l);
                //if (sMap.get(leftChar) == 1) sMap.remove(leftChar);
                //else 
                    sMap.put(leftChar, sMap.get(leftChar) - 1);
                
                l++;
                
                if (tMap.containsKey(leftChar) && sMap.getOrDefault(leftChar, 0) < tMap.get(leftChar)) {
                    matchCount--;
                }
                
            }
            
        }
        
        return res;
        //return  (minLen!= Float.POSITIVE_INFINITY) ? 
          //  s.substring(result[0], result[1] + 1) : "";
    }
    
    public String minWindow2(String s, String t) {
    int m = s.length(), n = t.length(), count = 0, start = 0, minWindow = Integer.MAX_VALUE;;
    String res = "";
    Map<Character, Integer> mapS = new HashMap<>();
    Map<Character, Integer> mapT = new HashMap<>();
    
    for (char c : t.toCharArray()) mapT.put(c, mapT.getOrDefault(c, 0) + 1);
    
    for (int i = 0; i < m; i++) {
        mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        if (mapT.containsKey(s.charAt(i)) && mapS.get(s.charAt(i)) <= mapT.get(s.charAt(i))) count++;
        while (count == n) {
            if (minWindow > i - start + 1) {
                minWindow = i - start + 1;
                res = s.substring(start, i + 1);
            }
            
            char curr = s.charAt(start);
            
            if (mapS.get(curr) == 1) mapS.remove(curr);
            else mapS.put(curr, mapS.get(curr) - 1);
            
            start++;
            
            if (mapT.containsKey(curr) && mapS.getOrDefault(curr, 0) < mapT.get(curr)) count--;
        }
    }
    return res;
}
}