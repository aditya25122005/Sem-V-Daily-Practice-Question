class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int num:happiness){
            pq.add(num);
        }
        int minus=0;
        long ans=0;
        while(k>0){
            if(pq.peek()>=minus){
                ans+=pq.poll()-minus;
                minus++;
                k--;
            }
            else{
                return ans;
            }
        }
        return ans;
    }
}