class MyStack {

    private final Queue<Integer> q1;
    private final Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        
        if (!q2.isEmpty()){
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }

        q1.add(x);
    }
    
    public int pop() {

       while (!q1.isEmpty()){
            q2.add(q1.remove());
       }

       while (q2.size() > 1){
            q1.add(q2.remove());
       }

       return q2.remove();

    }
    
    public int top() {

       while (!q1.isEmpty()){
            q2.add(q1.remove());
       }

       while (q2.size() > 1){
            q1.add(q2.remove());
       }

       int t = q2.peek();
       q1.add(q2.remove());

       return t;  
    }
    
    public boolean empty() {
        if (q1.isEmpty() && q2.isEmpty()) return true;
        else return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */