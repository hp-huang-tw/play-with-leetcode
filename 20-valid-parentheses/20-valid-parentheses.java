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
            } else if (!stack.isEmpty()) {
                Character p = stack.peek();
                if (c != parentheses.get(p)) return false;
                else stack.pop();
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}