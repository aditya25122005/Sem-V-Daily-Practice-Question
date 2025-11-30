class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums){
            pq.add(num);
        }
        long score=0;
        while(k!=0){
            int rm=pq.poll();
            score+=rm;
            pq.add((int)Math.ceil((double)rm/3));
            k--;
        }
        return score;
    }
}