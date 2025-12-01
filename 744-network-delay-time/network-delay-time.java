class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,HashMap<Integer,Integer>> map= new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new HashMap<>());
        }
        for(int i=0;i<times.length;i++){
            int v1=times[i][0];
            int v2=times[i][1];
            int cost=times[i][2];
            map.get(v1).put(v2,cost);
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.cost-b.cost);
        HashSet<Integer> visited= new HashSet<>();
        int count=0;
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair rm=pq.poll();
            int c= rm.cost;
            int v= rm.vtx;
            if(visited.contains(v)){
                continue;
            }
            visited.add(v);
            count++;
            if(count==n){
                return c;
            }
            for(int nbrs:map.get(v).keySet()){
                if(!visited.contains(nbrs)){
                    int cost= map.get(v).get(nbrs);
                    pq.add(new Pair(nbrs,c+cost));
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