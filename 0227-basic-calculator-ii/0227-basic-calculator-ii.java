class Solution {
    
    // TC: O(n), SC: O(1)
    public int calculate(String s) {
        int strLength = s.length();
        int res = 0, lastNumber = 0, currentNumber = 0;
        char operation = '+';
        
        for (int i = 0; i < strLength; i++) {
            char currentChar = s.charAt(i);
            
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            
            if (!Character.isDigit(currentChar) 
                && !Character.isWhitespace(currentChar) || i == strLength -1) {
                if (operation == '+' || operation == '-') {
                    res += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        
        res += lastNumber;
        
        return res;
    }
}