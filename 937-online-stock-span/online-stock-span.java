class StockSpanner {
    
    List<Integer> ll;
    public StockSpanner() {
        ll= new ArrayList<>();
    }
    
    public int next(int price) {
        ll.add(price);
        int n=ll.size();
        int cnt=1;
        for(int i=n-2;i>=0;i--){
            if(ll.get(i)<=price){
                cnt++;
            }
            else{
                return cnt;
            }
        }
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */