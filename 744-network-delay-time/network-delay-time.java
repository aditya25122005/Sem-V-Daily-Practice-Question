class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int [] cost= new int[n+1];
        Arrays.fill(cost,-1);
        cost[0]=0;
        cost[k]=0;
        HashMap<Integer,HashMap<Integer,Integer>> map= new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i, new HashMap<>());
        }
        for(int [] E: times){
            int u= E[0];
            int v= E[1];
            int time = E[2];
            map.get(u).put(v,time);
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        HashSet<Integer> visited= new HashSet<>();

        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair rm= pq.poll();
            if(visited.contains(rm.vtx)){
                continue;
            }
            visited.add(rm.vtx);
            for(int nbrs: map.get(rm.vtx).keySet()){
                int newCost= rm.cost+map.get(rm.vtx).get(nbrs);
                if(!visited.contains(nbrs)){
                    if(cost[nbrs]==-1 || cost[nbrs]> newCost){
                        cost[nbrs]=newCost;
                        pq.add(new Pair(nbrs,newCost));
                    }
                    
                }
                // cost[nbrs]=Math.min(cost[nbrs],newCost);
            }
        }

        boolean hasNeg=false;
        int ans=Integer.MIN_VALUE;
        for(int num: cost){
            if(num==-1) return -1;
            ans=Math.max(ans,num);
        }
        return ans;


    }
    static class Pair{
        int vtx;
        int cost;
        public Pair(int vtx, int cost){
            this.vtx=vtx;
            this.cost=cost;
        }
    }
}