class Solution {
    
    // TC: O(n), SC: O(n)
    public boolean wordPattern(String pattern, String s) {
        char[] patterns = pattern.toCharArray();
        String[] strs = s.split(" ");
        
        if (patterns.length != strs.length) return false;
        
        HashMap<Character, String> patternToStr = new HashMap<>();
        HashMap<String, Character> strToPattern = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            char p = patterns[i];
            if (patternToStr.containsKey(p) && !strs[i].equals(patternToStr.get(p))) return false;
            if (!patternToStr.containsKey(p) && strToPattern.containsKey(strs[i])) return false;    // pattern = "abba", s = "dog dog dog dog", false
            patternToStr.put(p, strs[i]);
            strToPattern.put(strs[i], p);
        }
        return true;
    }
}