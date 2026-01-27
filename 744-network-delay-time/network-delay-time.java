class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,HashMap<Integer,Integer>> map= new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i, new HashMap<>());
        }
        for(int [] E: times){
            int u= E[0];
            int v= E[1];
            int cost= E[2];
            map.get(u).put(v,cost);
        }
        List<Integer> ll= new ArrayList<>();
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> Integer.compare(a.cost,b.cost));
        pq.add(new Pair(k,0));
        HashSet<Integer> visited= new HashSet<>();
        while(!pq.isEmpty()){
            Pair rm= pq.poll();
            if(visited.contains(rm.vtx)) continue;
            visited.add(rm.vtx);
            ll.add(rm.cost);
            for(int nbrs: map.get(rm.vtx).keySet()){
                if(!visited.contains(nbrs)){
                    int cost= map.get(rm.vtx).get(nbrs)+ rm.cost;
                    pq.add(new Pair(nbrs,cost));
                }
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int num: ll){
            ans= Math.max(num,ans);
        }
        if(ll.size()<n) return -1;
        return ans==Integer.MIN_VALUE? -1:ans;


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