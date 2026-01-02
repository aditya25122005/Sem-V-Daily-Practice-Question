class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        for(int []A:edges){
            int u=A[0];
            int v=A[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }

        int connected=0;
        Queue<Integer> q= new LinkedList<>();
        HashSet<Integer> visited  = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                q.add(i);
                visited.add(i);
                int node=0;
                int edge=0;
                while(!q.isEmpty()){
                    int rm=q.poll();
                    node++;
                    edge+= map.get(rm).size();

                    // Add unvisited nbrs
                    

                    for(int nbrs: map.get(rm)){
                        if(!visited.contains(nbrs)){
                            visited.add(nbrs);
                            q.add(nbrs);
                        }
                    }
                    
                }
                if(edge/2== (node)*(node-1)/2) connected++;
            }
        }
        return connected;

    }
}