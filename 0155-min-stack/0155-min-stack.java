class MinStack {

    // -2 0 -3
    
    // -2 0
    
    // 0 -2 -3 
    
    // decreasing stack (using deque)
    // 5 4 3 2 1
    
    // -1 -2 0 -3
    
    // -1 -2
    /*
    while (n > stack.peak()) 
        a = stack.pop();
        // another list?
        [-1, -2]
        [0, -1, -2]
        n.push()
    
    */
    // 0    -2   -3
    
    // first     last
    
    // [x, min]
    // Stack<int[]> stack; 
    
    private Stack<int[]> stack;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[] { val, val });
            return;
        }
        
        int minVal = Math.min(val, stack.peek()[1]);
        stack.push(new int[] { val, minVal });
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */