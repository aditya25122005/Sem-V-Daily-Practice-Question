class Solution {
    public boolean isBipartite(int[][] graph) {
        return isPartite(graph);
    }
    public  boolean isPartite(int[][] graph){
        HashMap<Integer,Integer> visited= new HashMap<>();
        Queue<BipartitePair> q= new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(visited.containsKey(i)){
                continue;
            }
            q.add(new BipartitePair(i,0));
            while(!q.isEmpty()){
                BipartitePair rp=q.poll();
                int dis=rp.dis;
                int vtx=rp.vtx;

                if(visited.containsKey(vtx)){
                    if(visited.get(vtx)!=dis){
                        return false;
                    }
                    continue;
                }

                visited.put(vtx,dis);

                for(int nbrs:graph[vtx]){
                    if(!visited.containsKey(nbrs)){
                        q.add(new BipartitePair(nbrs,dis+1));
                    }
                }
            }
        }
        return true;

    }
    class BipartitePair{
    int vtx;
    int dis;
    public BipartitePair(int vtx,int dis){
        this.vtx=vtx;
        this.dis=dis;
    }
}
    
}
