class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left= new PriorityQueue<>(Collections.reverseOrder());// we want max element at top
        right= new PriorityQueue<>();// we want min element at top
    }
    
    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        if(right.size()>left.size()){
            left.add(right.poll());
        }

        // first add each element in left
        // then to balance we transfer from right to left

        // In the end either both PQ will be equal or left will be +1 than right
        //If equal ans is simple peek() of both /2.0
        // else ans will be peek of left;
    }
    
    public double findMedian() {
        if(left.size()==right.size()){
            return (left.peek()+right.peek())/2.0;
        }
        return (double) left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */