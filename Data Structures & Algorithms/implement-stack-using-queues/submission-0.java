class MyStack {
    Queue<Integer> queue ;
    public MyStack() {
       queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.offer(x);
        for(int i = queue.size() - 1 ; i > 0 ; i--){
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

// queue

// 1 2 3 4 
// enqueue wil happen on right end
// dequeu will happen on left end


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */