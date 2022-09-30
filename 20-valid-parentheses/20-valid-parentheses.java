class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> parentheses = Map.of('(', ')', 
                                                      '[', ']',
                                                      '{', '}');
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i=0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (parentheses.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || c != parentheses.get(stack.peek())) {
                return false;
            } else {
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}