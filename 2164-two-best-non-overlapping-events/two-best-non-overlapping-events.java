class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)-> a[0]-b[0]);
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        int bestPrev=0;
        int max=0;

        for(int i=0;i<events.length;i++){
            int start=events[i][0];
            int end=events[i][1];
            int val= events[i][2];
            while(!pq.isEmpty() && pq.peek()[0]<start){
               bestPrev=Math.max(bestPrev,pq.poll()[1]);
            }
            max=Math.max(max,bestPrev+val);

            pq.add(new int[]{end,val});
        }
        return max;
    }
    //3,2 -> 
}