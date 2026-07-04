class Solution {
    public int minScore(int n, int[][] roads) {


        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i, new HashMap<>());
        }
        for(int [] road: roads){
            int u = road[0];
            int v = road[1];
            int dis = road[2];
            map.get(u).put(v, Math.min(dis, map.get(u).getOrDefault(v,Integer.MAX_VALUE)));
            map.get(v).put(u, Math.min(dis, map.get(v).getOrDefault(u,Integer.MAX_VALUE)));
        }
        int res = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        q.add(1);
        while(!q.isEmpty()){
            int rm = q.poll();
            if(vis.contains(rm)) continue;
            vis.add(rm);
            for(int nbrs: map.get(rm).keySet()){
                res = Math.min(res, map.get(rm).get(nbrs));
                if(!vis.contains(nbrs)){
                    q.add(nbrs);
                }
            }

        }
        return res;
        // int [][] dis = new int[n+1][n+1];
        // for(int [] A: dis) Arrays.fill(A,Integer.MAX_VALUE);
        // // dis[1][1] = 0;
        // PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.dis,b.dis));
        // pq.add(new Pair(1,Integer.MAX_VALUE));
        // int res = Integer.MAX_VALUE;
        // while(!pq.isEmpty()){
        //     Pair rm = pq.poll();
        //     if(rm.vtx == n){
        //         res = Math.min(res, rm.dis);
        //     }
        //     for(int nbrs: map.get(rm.vtx).keySet()){
        //         int newDis = Math.min(rm.dis, map.get(rm.vtx).get(nbrs));
        //         if(newDis<dis[rm.vtx][nbrs]){
        //             dis[rm.vtx][nbrs] = newDis;
        //             pq.add(new Pair(nbrs,newDis));
        //         }
        //     }
        // }
        // return -1;

    }
    static class Pair{
        int vtx;
        int dis;
        public Pair(int vtx, int dis){
            this.vtx = vtx;
            this.dis = dis;
        }
    }
}