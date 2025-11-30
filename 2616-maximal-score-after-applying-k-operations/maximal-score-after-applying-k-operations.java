class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        for(int num:nums){
            pq.add(num);
        }
        long score=0;
        while(k!=0){
            int rm=pq.poll();
            int b= rm/3;
            if(rm%3!=0) b++;
            score+=rm;
            pq.add(b);
            k--;
        }
        return score;
    }
}