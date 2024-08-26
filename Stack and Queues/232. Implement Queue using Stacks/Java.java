class MyQueue {

    private final Stack<Integer> input;
    private final Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        peek();
        return output.pop();
    }
    
    public int peek() {
        if (output.empty()){
            while (!input.empty()){
                output.push(input.pop());
            }
        }   
        return output.peek();  
    }

    
    public boolean empty() {
        if (output.empty() && input.empty()) return true;
        else return false;
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