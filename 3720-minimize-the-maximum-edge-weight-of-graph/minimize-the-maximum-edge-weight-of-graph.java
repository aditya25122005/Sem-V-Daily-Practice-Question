class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        HashMap<Integer,HashMap<Integer,Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new HashMap<>());
        }
        for(int [] E: edges){
            int u= E[0];
            int v= E[1];
            int w= E[2];
           // map.get(v).put(u,w);
            if(!map.get(v).containsKey(u)){
                map.get(v).put(u,w);
            }
            else{
                int old = map.get(v).get(u);
                if(w< old){
                    map.get(v).put(u,w);;
                }
            }
        }

        boolean [] vis= new boolean[n];
        int max=Integer.MIN_VALUE;

        PriorityQueue<int[]> q= new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int [] rm = q.poll();
            int vtx= rm[0];
            int wt = rm[1];
            if(vis[vtx]) continue;
            vis[vtx]=true;
            max=Math.max(max,wt);

            for(int nbrs : map.get(vtx).keySet()){
                int edgeCost = map.get(vtx).get(nbrs);
                if(!vis[nbrs]){
                    q.add(new int[]{nbrs, edgeCost});
                }
            }
        }
        // int max=Integer.MIN_VALUE;
        for(int i=1;i<vis.length;i++){
            if(!vis[i]) return -1;
        }
        return max;
    }
}