class Solution {
    
    // TC: O(n). SC: O(n)
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        // Deque<Integer> stack = new ArrayDeque();
        
        for (int ast : asteroids) {
            boolean push = true;
            
            // collide successully. e.g, [1, 2, -3]
            // diff way and size of ast > prev, pop prev
            while (!stack.isEmpty() && isCollision(stack.peek(), ast)) {
                int curAstSize = Math.abs(ast);
                int preAstSize = stack.peek();
                
                if (curAstSize > preAstSize) {
                    stack.pop();
                } else if (curAstSize <= preAstSize) {  // collide failed. e.g, [1, 5, -3]
                    push = false;
                    if (curAstSize == preAstSize) {  // [1, 5, -5]
                        stack.pop();
                    }
                    break;
                }
            }
            
            if (push) {
                stack.push(ast);
            }
        }
        
        
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i > -1; i--) {
            res[i] = stack.pop();
        }
        // int i = 0;
        // while (!stack.isEmpty()) {
        //     res[i++] = stack.pollLast();
        // }
        return res;
    }
    
    boolean isCollision(int a, int b) {
        return a > 0 && b < 0;
    }
    
    // [1 2 -3]
    // 1 2
    // 1 -3
    // -3
    
    // [5,10,-5]
    // 5
    // 5 10
    // 5 10

    // [8,-8]
    // 8
    // 
    
    // [10,2,-5]
    // 10
    // 10 2
    // 10 -5 
    // -> 10
    
    // [-5 -1 10]
    // -5
    // -5 -1 
    // -5 -1 10
}