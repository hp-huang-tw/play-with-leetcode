class Solution {
    
    String s;
    
    String p;
    
    int sLen;
    
    int pLen;
    
    // TC: O(n * m)
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        sLen = s.length();
        pLen = p.length();
        return dpTopDown(0, 0);
    }
    
    private boolean dpTopDown(int i, int j) {
        // both of i and j is out of bound. exactly matched.
        if (i >= sLen && j >= pLen) return true;
        // j is out of bound. i is inside of bound. not matched. aa, a
        if (j >= pLen) return false;
        
        boolean match = i < sLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        // next character is '*'
        if (j + 1 < pLen && p.charAt(j + 1) == '*') {
            return dpTopDown(i, j + 2) || // not use *
                    (match && dpTopDown(i + 1, j)); // use
        }
        
        if (match) return dpTopDown(i + 1, j + 1);
        
        return false;
    }
}