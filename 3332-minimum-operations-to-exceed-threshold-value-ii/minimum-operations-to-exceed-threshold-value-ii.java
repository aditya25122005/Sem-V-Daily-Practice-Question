class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq= new PriorityQueue<>();
        for(int num:nums){
            if(num<k){
                pq.add((long)num);
            }
        }
        if(pq.size()==1){
            return 1;
        }
        int opr=0;


        while(pq.size()>1){
            long a=pq.poll();
            long b=pq.poll();
            long insert=a*2 +b;
            if(insert<k){
                pq.add(insert);
            }
            opr++;
        }
        if(pq.size()==1){
            return opr+1;
        }
        return opr;
    }
}