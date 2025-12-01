class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<patience.length;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int v1= edges[i][0];
            int v2= edges[i][1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> a.cost-b.cost);
        HashSet<Integer> visited= new HashSet<>();
        HashMap<Integer,Integer> costMap= new HashMap<>();
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair rp=pq.poll();
            if(visited.contains(rp.vtx)){
                continue;
            }
            visited.add(rp.vtx);
            costMap.put(rp.vtx,rp.cost);

            for(int nbrs:map.get(rp.vtx)){
                if(!visited.contains(nbrs)){
                    pq.add(new Pair(nbrs,rp.cost+1));
                }
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int key:costMap.keySet()){
            if(key!=0){
            int dist=costMap.get(key)*2;

            if(patience[key]>=dist){
                ans=Math.max(ans,dist);
            }
            else{
                ans=Math.max(ans,dist+((dist-1)/patience[key])*patience[key]);
            }
            
            
            }
        }
        return ans+1;

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