class Solution {
    // ()
    // ([{}[]]) 
    //   ^^^^^
    // stack    c
    // (      | (
    // ([     | [
    // ([{    | {
    // ([{    | }   pop {
    // ([[    | [
    // ([[    | ]   pop [
    // ([
    // ..
    // ""     return true
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || c != map.get(stack.peek())) {  // { | ], // "" | ]
              return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}