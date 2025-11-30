class Solution {
    public int halveArray(int[] nums) {
        double sum=0;
        for(int num:nums){
            sum+=num;
        }
        double target= (double)sum/2;
        PriorityQueue<Double> pq= new PriorityQueue<>((a,b)->Double.compare(b,a));
        for(int num:nums){
            pq.add((double)num);
        }
        int opr=0;
        while(sum>target){
            double rm= pq.poll();
            double half= (double)rm/2;
            sum-= half;
            opr++;
            if(sum<=target) return opr;
            pq.add(half);
        }
        return opr;
    }
}