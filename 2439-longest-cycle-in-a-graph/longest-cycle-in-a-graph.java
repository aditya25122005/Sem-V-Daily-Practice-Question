class Solution {
    public int longestCycle(int[] edges) {
        int [] in = new int [edges.length];
        for(int i=0;i<edges.length;i++){
            if(edges[i]==-1) continue;
            in[edges[i]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean [] vis = new boolean [edges.length];
        for(int i=0;i<edges.length;i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int rm = q.poll();
            vis[rm] = true;

            int nbrs = edges[rm];
            if(nbrs!=-1){
                in[nbrs]--;
            }
            if(nbrs!=-1){
                if(in[nbrs]==0){
                    q.add(nbrs);
                }
            }
        }


        int ans = -1;
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                vis[i] = true;
                int c = 1;
                int nbrs = edges[i];
                while(nbrs!=i){
                    c++;
                    vis[nbrs] = true;
                    nbrs = edges[nbrs]; 
                }
                ans = Math.max(ans,c);
            }
        }
        return ans;
    }
}