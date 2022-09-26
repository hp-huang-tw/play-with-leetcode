class Solution {
    public boolean isSubsequence(String s, String t) {        
        int tIndex=0;
        int matchCount=0;
        
        for (int i=0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            
            while(tIndex < t.length()) {
                if (t.charAt(tIndex) == c1) {
                    matchCount++;
                    tIndex++;
                    break;
                }
                tIndex++;
            }
        }
        
        return (matchCount==s.length());
    }
}