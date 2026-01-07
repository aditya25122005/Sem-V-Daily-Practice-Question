class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n= values.length;
        HashMap<Integer,HashMap<Integer,Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new HashMap<>());
        }
        for(int []E :edges){
            int u=E[0];
            int v=E[1];
            int time=E[2];
            map.get(u).put(v,time);
            map.get(v).put(u,time);
        }
        int[] visited= new int[n];
        ans=0;
        Solve(map,visited,values,0,0,0,maxTime);
        return ans; 
    }
    int ans;
    public  void Solve(HashMap<Integer,HashMap<Integer,Integer>> map, int[] visited, 
    int[] values, int vtx, int currTime, int v,int maxTime){

        if(currTime>maxTime){
            return;
        }
        if(visited[vtx]==0){
            v+= values[vtx];
        }
        if(vtx==0){
            ans=Math.max(ans,v);
        }
        visited[vtx]++;
        for(int nbrs:map.get(vtx).keySet()){
            int t=map.get(vtx).get(nbrs);
            Solve(map,visited,values,nbrs,currTime+t,v,maxTime);
        }
        visited[vtx]--;

    }
}