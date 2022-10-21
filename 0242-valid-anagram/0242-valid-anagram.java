class Solution {
    public boolean isAnagram(String s, String t) {
        return counter(s, t);
    }
    
    // TC: O(s+t) -> O(n)
    // SC: O(s+t) -> O(n)
    private boolean hashMap(String s, String t) {
        if (s.length() != t.length()) return false;
        
        HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        return mapS.equals(mapT);
    }
    
    // TC: O(nlog(n)) or O(n^2)
    // SC: O(1), or O(n)
    private boolean sort(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }
    
    private boolean counter(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] countS = new int[26];
        int[] countT = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            countT[t.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (countS[i] != countT[i]) {
                return false;
            }
        }
        return true;
    }
}