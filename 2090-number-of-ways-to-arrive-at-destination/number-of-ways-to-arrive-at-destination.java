class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod=1000000007;

        HashMap<Integer,HashMap<Integer,Integer>> map= new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.put(i, new HashMap<>());
        }
        for(int [] A:roads){
            int u=A[0];
            int v=A[1];
            int cost=A[2];
            map.get(u).put(v,cost);
            map.get(v).put(u,cost);
        }
        long [] dis= new long[n];
        long [] path= new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[0]=0;
        path[0]=1;
        

        PriorityQueue<long[]> pq= new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));

        pq.add(new long[]{0,0});
        

        while(!pq.isEmpty()){
            // remove

            long[] rm= pq.poll();
            int vtx=(int)rm[0];
            long cost= rm[1];

            // ignore

            if(cost>dis[vtx]) continue;

            // Add unvisited nbrs

            for(int nbrs: map.get(vtx).keySet()){
                
                    long Newcost= map.get(vtx).get(nbrs)+cost;
                    if(Newcost< dis[nbrs]){
                        dis[nbrs]= (long)Newcost;
                        path[nbrs]=path[vtx];
                        pq.add(new long[]{nbrs,Newcost});
                    }
                    else if(Newcost==dis[nbrs]){
                        path[nbrs]=(path[nbrs]+path[vtx])%mod;
                    }
            }
        }

        return (int)path[n-1];
    }
}