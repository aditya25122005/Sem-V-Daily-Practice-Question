class Solution {
    public int minCost(int n, int[][] edges) {
        HashMap<Integer,HashMap<Integer,Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new HashMap<>());
        }
        for(int [] E: edges){
            int u= E[0];
            int v= E[1];
            int w= E[2];

            map.get(u).put(v,Math.min(map.get(u).getOrDefault(v,Integer.MAX_VALUE),w));
            map.get(v).put(u,Math.min(map.get(v).getOrDefault(u,Integer.MAX_VALUE),2*w));

        }
        int ans=Integer.MAX_VALUE;
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        pq.add(new Pair(0,0));
        HashSet<Integer> visited= new HashSet<>();
        while(!pq.isEmpty()){
            Pair rm= pq.poll();
            if(visited.contains(rm.vtx)) continue;
            visited.add(rm.vtx);
            if(rm.vtx==n-1) ans=Math.min(ans,rm.cost);

            for(int nbrs:map.get(rm.vtx).keySet()){
                int cost= rm.cost+ map.get(rm.vtx).get(nbrs);
                pq.add(new Pair(nbrs,cost));
            }
        }
        return ans==Integer.MAX_VALUE? -1: ans;
    }
    class Pair{
        int vtx;
        int cost;

        public Pair(int vtx, int cost){
            this.vtx= vtx;
            this.cost =cost;
        }
    }
}