class Solution {
    public int minCost(int n, int[][] edges) {
        HashMap<Integer,HashMap<Integer,Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new HashMap<>());
        }
        for(int []A:edges){
            int u=A[0];
            int v=A[1];
            int wt=A[2];
            map.get(u).put(v, Math.min(map.get(u).getOrDefault(v,Integer.MAX_VALUE),wt));
            map.get(v).put(u ,Math.min(map.get(v).getOrDefault(u,Integer.MAX_VALUE),2*wt));
        }
        int [] best= new int[n];
        Arrays.fill(best,-1);
        best[0]=0;
        HashSet<Integer> visited= new HashSet<>();
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair rm=pq.poll();
            int vtx=rm.vtx;
            int cost=rm.cost;

            if(visited.contains(vtx)) continue;
            if(cost>best[vtx]) continue;

            visited.add(vtx);

            if(vtx==n-1) return cost;
            
            for(int nbrs:map.get(vtx).keySet()){
                if(best[nbrs]==-1 || best[nbrs]>cost+map.get(vtx).get(nbrs)){
                    int newCost=cost+map.get(vtx).get(nbrs);
                    best[nbrs]=newCost;
                    pq.add(new Pair(nbrs,newCost));
                }
            }



        }
        return -1;

    }
    class Pair{
        int vtx;
        int cost;
        public Pair(int vtx, int cost){
            this.vtx=vtx;
            this.cost=cost;
        }
    }
}