class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        String[] ans= new String[n];
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b) -> score[b]-score[a] );
        for(int i=0;i<n;i++){
            pq.add(i);
        }
        int rank=1;
        while(!pq.isEmpty()){
            int idx=pq.poll();
            if(rank==1){
                ans[idx]="Gold Medal";
            }
            else if(rank==2){
                ans[idx]="Silver Medal";
            }
            else if(rank==3){
                ans[idx]="Bronze Medal";
            }
            else{
                ans[idx]=String.valueOf(rank);
            }
            rank++;
        }
        return ans;
    }
}