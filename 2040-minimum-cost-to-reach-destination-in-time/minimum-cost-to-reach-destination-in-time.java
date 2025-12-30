class Solution {
    public int minCost(int maxTime, int[][] edges, int[] fees) {
        int n=fees.length;
        int [][] best= new int[fees.length][maxTime+1];
        HashMap<Integer,HashMap<Integer,Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());
        }
        for(int []A:edges){
            map.get(A[0]).put(A[1],Math.min(map.get(A[0]).getOrDefault(A[1],Integer.MAX_VALUE), A[2]));
            map.get(A[1]).put(A[0],Math.min(map.get(A[1]).getOrDefault(A[0],Integer.MAX_VALUE), A[2]));
        }
        for(int i=0;i<n;i++){
            Arrays.fill(best[i],Integer.MAX_VALUE);
        }
        best[0][0]=fees[0];
        // node tak pahuchne ka minCost -> in t time (best[node][t])
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(0,fees[0],0));
        while(!pq.isEmpty()){
            Pair rm=pq.poll();
            int vtx=rm.vtx;
            int cost=rm.cost;
            int time=rm.time;
            if(cost>best[vtx][time]) continue;

            if(vtx==n-1){
                return cost;
            }
            if(time>maxTime){
                continue;
            }
            

            for(int nbrs:map.get(vtx).keySet()){
                int newTime= time+map.get(vtx).get(nbrs);
                int newCost=cost+fees[nbrs];

                if( newTime<=maxTime &&  newCost<best[nbrs][newTime]){
                    best[nbrs][newTime]=newCost;
                    pq.add(new Pair(nbrs,newCost,newTime));
                }
            }
        }
        return -1;

    }
    class Pair{
        
        int vtx;
        int cost;
        int time;

        public Pair(int vtx,int cost, int time){
            this.vtx=vtx;
            this.cost=cost;
            this.time=time;
        }
    }
}