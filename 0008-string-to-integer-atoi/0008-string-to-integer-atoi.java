class Solution {
    
    // digit: [0-9]
    // sign: +/-
    // space: read nums
    

    // 0032 -> 32
    // 2.6 -> 2
    // words and 1234 -> 0
    // w234 -> 0
    // 1w20 -> 1
    public int myAtoi(String s) {
        int strLen = s.length();
        int i = 0;
        int res = 0;
        
        int sign = 1;
        
        // ignore whitespace at the beginning. "   123"
        while (i < strLen && s.charAt(i) == ' ') {
            i++;
        }
        
        // check the sign
        // -12 -> -12
        // 12- -> 12
        if (i < strLen) {
            if (s.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            }
        }
        
        // w12 -> not a digit
        while (i < strLen && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            // check overlfow and underflow conditions
            if ((res > Integer.MAX_VALUE / 10) || 
                (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {     
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.    
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            res = 10 * res + digit;
            i++;
        }
        
        return sign * res;
    }
}