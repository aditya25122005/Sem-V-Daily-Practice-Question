class Solution {
    public int maximumRobots(int[] charge, int[] run, long budget) {
        long sum=0;
        int ans=0;
        int j=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<charge.length;i++){
            sum+=run[i];
            pq.add(charge[i]);

            while(!pq.isEmpty() && (sum*pq.size() + pq.peek())>budget){
                pq.remove(charge[j]);
                sum-=run[j];
                j++;
            }
            ans=Math.max(ans,pq.size());
        }
        return ans;
    }
}