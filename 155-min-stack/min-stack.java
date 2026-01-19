class MinStack {
    List<Integer> ll;
    Stack<Integer> min;


    public MinStack() {
        ll= new ArrayList<>();
        min= new Stack<>();
        min.push(Integer.MAX_VALUE);

    }
    
    public void push(int val) {
        if(val < min.peek()){
            min.push(val);
        }
        else{
            min.push(min.peek());
        }
        ll.add(val);
    }
    
    public void pop() {
        int v= ll.get(ll.size()-1);
        ll.remove(ll.size()-1);
        min.pop();
  
        
    }
    
    public int top() {
        return ll.get(ll.size()-1);
    }
    
    public int getMin() {
        return min.peek();
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