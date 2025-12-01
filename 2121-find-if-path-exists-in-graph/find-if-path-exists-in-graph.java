class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination){
            return true;
        }
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a= edges[i][0];
            int b= edges[i][1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        HashSet<Integer> visited= new HashSet<>();
        Queue<Integer> q= new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()){
            // Remove
            int rm= q.poll();
            // Ignore
            if(visited.contains(rm)){
                continue;
            }
            // Mark Visited
            visited.add(rm);
            // Self Work
            if(rm==destination){
                return true;
            }
            // Add Unvisited nbrs
            for(int nbrs:map.get(rm)){
                if(!visited.contains(nbrs)){
                    q.add(nbrs);
                }
            }
            
        }
        return false;
    }
}