class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        Arrays.sort(happiness);
        int minus=0;
        long ans=0;
        
        for(int i=n-1;i>=0;i--){
            if(k>0 && happiness[i]-minus>=0){
                ans+=happiness[i]-minus;
                minus++;
                k--;
            }
            else{
                return ans;
            }
        }
        return ans;
        // PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        // for(int num:happiness){
        //     pq.add(num);
        // }
        // int minus=0;
        // long ans=0;
        // while(k>0){
        //     if(pq.peek()>=minus){
        //         ans+=pq.poll()-minus;
        //         minus++;
        //         k--;
        //     }
        //     else{
        //         return ans;
        //     }
        // }
        // return ans;
    }
}