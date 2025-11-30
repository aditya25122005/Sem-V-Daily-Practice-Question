class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> b-a);
        for(int num:piles){
            pq.add(num);
        }
        while(k-->0){
            int rm=pq.poll();
            int a= rm/2;
            pq.add(rm-a);
        }
        int sum=0;
        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;
    }
}