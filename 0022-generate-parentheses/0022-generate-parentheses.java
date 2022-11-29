class Solution {
    
    Stack<String> stack = new Stack();
    
    List<String> res = new ArrayList<>();
    
    int n = 0;
    
    public List<String> generateParenthesis(int n) {
        this.n = n;
        generateParenthesis(0, 0);
        return res;
    }
    
    //          (
    //        /.  \
    //      ((     ()
    private void generateParenthesis(int openCount, int closeCount) {
        if (openCount == n && closeCount == n) {
            res.add(String.join("", stack));
            return;
        }
        
        if (openCount < n) {
            stack.push("(");
            generateParenthesis(openCount + 1, closeCount);
            stack.pop();
        }
        
        if (closeCount < openCount) {
            stack.push(")");
            generateParenthesis(openCount, closeCount + 1);
            stack.pop();
        }
    }
}