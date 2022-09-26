class Solution {

    public boolean isIsomorphic(String s, String t) {
        // 
        // e g g
        // a d d
        HashMap<Character, Character>map = new HashMap<>();
        for (int i=0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            // foo --> bar. o!=r
            // bar --> foo
            if (map.containsKey(c1)) {
                if(map.get(c1)!=c2) {
                    return false;
                }
            }
            else {
                map.put(c1, c2);
            }
        }
        
        HashSet<Character> distinct = new HashSet<>(map.values());
        
        if (map.size() != distinct.size()) {
            return false;
        }
        
        return true;
    }
}