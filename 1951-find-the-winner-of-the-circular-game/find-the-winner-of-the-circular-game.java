class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> ll = new ArrayList<>();
        for(int i=1;i<=n;i++){
            ll.add(i);
        }
        int idx=0;
        while(ll.size()>1){
            int rmIdx= (idx+k-1)%ll.size();
            ll.remove(rmIdx);
            idx= rmIdx;
        }
        return ll.get(0);


    }
}