class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int num:stones) pq.add(num);
        while(pq.size()>=2){
            int a= pq.poll();
            int b=pq.poll();
            if(a!=b){
                pq.add(a-b);
            }
        }
        if(pq.isEmpty()) return 0;
        return pq.poll();
    }
}