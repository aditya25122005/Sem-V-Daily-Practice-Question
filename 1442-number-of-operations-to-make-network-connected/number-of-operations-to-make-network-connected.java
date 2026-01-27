class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;// Not enough cables;
        }

        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        for(int [] E: connections){
            int u= E[0];
            int v= E[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        

        // Just find components
        // TO connect K components we should have (K-1) edges extra
        // Total Edges we have= connections.length

        int comp=0;
        HashSet<Integer> visited= new HashSet<>();
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                // visited.add(i);
                q.add(i);
                comp++;
                while(!q.isEmpty()){
                    int rm= q.poll();
                    if(visited.contains(rm)) continue;
                    visited.add(rm);
                    for(int nbrs:map.get(rm)){
                        if(!visited.contains(nbrs)){
                            q.add(nbrs);
                        }
                    }
                }
            }
        }
        int extraNeed= comp-1;
        return extraNeed;
        
    }
}