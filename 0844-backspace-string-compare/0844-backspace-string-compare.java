class Solution {
    public boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }
    
    private String processString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch != '#') {   
                stack.push(ch);
            } else if (!stack.isEmpty()){
                stack.pop();
            }
        }
        
        return String.valueOf(stack);
    }
}