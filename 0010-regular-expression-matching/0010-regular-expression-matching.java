class Solution {
    
    String s;
    
    String p;
    
    int sLen;
    
    int pLen;
    
    Boolean[][] cached;
    
    // TC: O(n * m). SC: O(n * m)
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        sLen = s.length();
        pLen = p.length();
        cached = new Boolean[sLen + 1][pLen + 1];
        return dpTopDown(0, 0);
    }
    
    // with memoization
    private boolean dpTopDown(int i, int j) {
         if (cached[i][j] != null) return cached[i][j];
        
        // both of i and j is out of bound. exactly matched.
        if (i >= sLen && j >= pLen) return true;
        // j is out of bound. i is inside of bound. not matched. aa, a
        if (j >= pLen) return false;
        
        boolean match = i < sLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        // if next character is '*'
        if (j + 1 < pLen && p.charAt(j + 1) == '*') {
            cached[i][j] = dpTopDown(i, j + 2) || // not use *
                (match && dpTopDown(i + 1, j)); // use 
        } else if (match) {
            cached[i][j] = dpTopDown(i + 1, j + 1);
        } else {
            cached[i][j] = false;
        }
        
        return cached[i][j];
    }
}