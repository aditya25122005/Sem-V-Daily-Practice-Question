class Solution {
    public boolean isBipartite(int[][] graph) {
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<graph.length;i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                map.get(i).add(graph[i][j]);
            }
        }
        HashMap<Integer,Integer> visited= new HashMap<>();
        Queue<Pair> q= new LinkedList<>();
        for(int src : map.keySet()){
            if(visited.containsKey(src)) continue;
            if(!visited.containsKey(src)){
                // visited.put(src,0);
                q.add(new Pair(src,0));
                while(!q.isEmpty()){
                    Pair rm= q.poll();
                    if(visited.containsKey(rm.vtx)){
                        if(visited.get(rm.vtx)!= rm.dis) return false;
                        continue;
                    }
                    visited.put(rm.vtx,rm.dis);
                    for(int nbrs: map.get(rm.vtx)){
                        if(!visited.containsKey(nbrs)){
                            q.add(new Pair(nbrs, rm.dis+1));
                        }
                    }

                    
                }
            }
        }
        return true;
    }
    class Pair{
        int vtx;
        int dis;

        public Pair(int vtx, int dis){
            this.vtx=vtx;
            this.dis=dis;
        }
    }
}