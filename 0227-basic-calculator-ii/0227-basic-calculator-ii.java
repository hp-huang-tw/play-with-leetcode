class Solution {
    
    // basic template. could extend for
    // - https://leetcode.com/problems/basic-calculator/
    // - https://leetcode.com/problems/basic-calculator-iii/
    // stack solution
    // TC: O(n)
    // SC: O(n)
    public int calculate(String s) {
        // if (s == null || s.isEmpty()) return 0; // if s == null or s == ""
        int strLen = s.length();
        Stack<Integer> stack = new Stack();
        int sign = '+';
        int num = 0;
        for (int i = 0; i < strLen; i++) {
            char c = s.charAt(i);
            
            // 11
            //  ^      -> sign = '+', num = 1 * 10 + 1 = 11
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            
            // 11 - 1 + 2 
            //        ^      -> sign = '-', num = 1
            // 11, -1 + 2
            //          ^    -> sign = '+', num = 2
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == strLen - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                
                num = 0;
                sign = c;
            }
        }
        
        
        
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
        // return stack.stream().mapToInt(Integer::intValue).sum();
    }
    
    // Optimised Approach without the stack
    // TC: O(n), SC: O(1)
    public int calculateSolution2(String s) {
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