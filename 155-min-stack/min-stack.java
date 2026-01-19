class MinStack {
    List<Integer> ll;


    public MinStack() {
        ll= new ArrayList<>();

    }
    
    public void push(int val) {
        ll.add(val);
    }
    
    public void pop() {
        int v= ll.get(ll.size()-1);
        ll.remove(ll.size()-1);
  
        
    }
    
    public int top() {
        return ll.get(ll.size()-1);
    }
    
    public int getMin() {
        int min=Integer.MAX_VALUE;
        for(int num:ll){
            min=Math.min(min,num);
        }
        return min;
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