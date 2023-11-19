class MyQueue {
    
    private Stack<Integer> inputStack;
    
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack();
        outputStack = new Stack();
    }
    
    // O(1), O(1)
    public void push(int x) {
       inputStack.push(x);
    }
    
    // O(1), O(1)
    public int pop() {
        transferElements();
        return outputStack.pop();
    }
    
    // O(1), O(1)
    public int peek() {
        transferElements();
        return outputStack.peek();
    }
    
    private void transferElements() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
    
    // O(1), O(1)
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */