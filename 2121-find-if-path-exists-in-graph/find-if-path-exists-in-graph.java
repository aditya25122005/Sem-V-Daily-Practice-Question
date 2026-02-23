class Solution {
    public boolean validPath(int n, int[][] edges, int src, int des) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int [] E: edges){
            int u= E[0];
            int v= E[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        Queue<Integer> q= new LinkedList<>();
        q.add(src);
        HashSet<Integer> visited= new HashSet<>();
        while(!q.isEmpty()){
            int rm= q.poll();
            if(visited.contains(rm)){
                continue;
            }
            visited.add(rm);
            if(rm==des) return true;
            for(int nbrs : map.get(rm)){
                if(!visited.contains(nbrs)){
                    q.add(nbrs);
                }
            }
        }
        return false;
    }
}