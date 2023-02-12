class Solution {
    // O(n), O(1)
    // odd: 1221 -> 12|12 return true
    // even: 12321 -> 12|123
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x > 0)) { // last digit is 0, e.g. 1010 -> 10|01
            return false;
        }
        
        int reverted = 0;
        while (x > reverted) {
            reverted = reverted * 10 + x % 10;  // 1, 10+2=12
            x /= 10;    // 122, 12
        }
        
        return x == reverted || x == reverted/10;
    }
    
    private boolean convertToString(int x) {
        String s = String.valueOf(x);
        
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        
        return true;
    }
}