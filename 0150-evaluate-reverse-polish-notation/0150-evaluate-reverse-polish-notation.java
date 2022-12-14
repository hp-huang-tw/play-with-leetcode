class Solution {
    
    // ["2","1","+","3","*"]
    
    // a b
    // stack        opt      a (opt) b
    // 2 1
    //              +         
    // 3                    "2 + 1 =3"
    // 3 3          *
    // 9                     3 * 3 = 9
    
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPTS = new HashMap<>();
    
    static {
        OPTS.put("+", (a, b) -> a + b);
        OPTS.put("-", (a, b) -> a - b);
        OPTS.put("*", (a, b) -> a * b);
        OPTS.put("/", (a, b) -> a / b);
        
    }
    
    // TC: O(n). SC: O(n)
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        
        for (String s : tokens) {
            if (OPTS.containsKey(s)) {
                int b = stack.pop();
                int a = stack.pop();
                BiFunction<Integer, Integer, Integer> opt = OPTS.get(s);
                stack.push(opt.apply(a, b));
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        
        return stack.pop();
    }
}