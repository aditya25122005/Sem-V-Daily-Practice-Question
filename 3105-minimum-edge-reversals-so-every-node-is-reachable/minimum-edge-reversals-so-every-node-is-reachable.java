class Solution {
    boolean [] visited;
    int total;
    int [] ans;
    public int[] minEdgeReversals(int n, int[][] edges) {
        
        HashMap<Integer,HashMap<Integer,Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new HashMap<>());
        }

        for(int []E:edges){
            int u= E[0];
            int v= E[1];
            map.get(u).put(v,0);
            map.get(v).put(u,1);
        }
        ans= new int[n];
        visited= new boolean[n];

        DFS(0,map);
        ans[0]=total;

        Arrays.fill(visited,false);
        Solve(0,map);
        total=0;
        return ans;


    }
    public  void DFS(int u, HashMap<Integer,HashMap<Integer,Integer>> map){
        visited[u] = true;
        for(int nbrs: map.get(u).keySet()){
            int cost= map.get(u).get(nbrs);
            if(!visited[nbrs]){
                total+=cost;
                DFS(nbrs,map);
            }
        }
    }

    public  void Solve(int u, HashMap<Integer,HashMap<Integer,Integer>> map){
        visited[u]=true;
        for(int nbrs:map.get(u).keySet()){
            int cost = map.get(u).get(nbrs);
            if(!visited[nbrs]){
                if(cost==0){
                    ans[nbrs]=ans[u]+1;
                }
                else{
                    ans[nbrs]=ans[u]-1;
                }
                Solve(nbrs,map);
            }
        }
    }

}