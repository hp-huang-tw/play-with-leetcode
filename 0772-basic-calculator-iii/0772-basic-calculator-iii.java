class Solution {
    // basic template. could extend for
    // - https://leetcode.com/problems/basic-calculator/
    // - https://leetcode.com/problems/basic-calculator-ii/
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
            
            // brace recursive calculate function
            // ((1 + 2) + 3) + 1            ->  (1 + 2) + 3     -> 3 + 3 = 6
            // i.          j                    i.....j
            // ^-----------^                    ^-----^        
            //        move i to j
            if (c == '(') {
                int braces = 1;
                int j = i + 1;
                for (; j < strLen; j++) {
                    if (s.charAt(j) == '(') braces++;
                    if (s.charAt(j) == ')') braces--;
                    if (braces == 0) break;
                }
                num = calculate(s.substring(i + 1, j));
                i = j;
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
}