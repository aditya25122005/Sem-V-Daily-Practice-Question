class Solution {
    public boolean isBipartite(int[][] graph) {
        return isBipartite1(graph);
    }
    
    public boolean isBipartite1(int[][] graph){
        Queue<BipartitePair> q= new LinkedList<>();
        HashMap<Integer,Integer> visited= new HashMap<>();
        for(int key=0;key<graph.length;key++){
            if(visited.containsKey(key)){
                continue;
            }
            q.add( new BipartitePair(key, 0));
            while(!q.isEmpty()){
                // Remove
                BipartitePair rp= q.poll();
                // Ignore if already visited
                if(visited.containsKey(rp.vtx)){
                    if(visited.get(rp.vtx)!=rp.dis){
                        return false;
                    }
                    continue;
                }
                // Mark visited
                visited.put(rp.vtx,rp.dis);
                // SELF WORK -> Not in this case

                // Add unvisited Neighbours
                for(int nbrs:graph[rp.vtx]){
                    if(!visited.containsKey(nbrs)){
                        q.add(new BipartitePair(nbrs, rp.dis+1));
                    }
                    
                }


            }
        }
        return true;

    }
    class BipartitePair{
        int vtx;
        int dis;
        public BipartitePair(int vtx, int dis){
            this.vtx=vtx;
            this.dis=dis;
        }
    }
}