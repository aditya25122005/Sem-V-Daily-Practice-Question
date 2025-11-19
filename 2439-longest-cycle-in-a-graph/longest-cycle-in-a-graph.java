class Solution {
    public int longestCycle(int[] edges) {
        return FindLongestCycle(edges);
    }
    public static int FindLongestCycle(int[] edges){
        int [] in= new int[edges.length];
        for(int i=0;i<edges.length;i++){
            if(edges[i]!=-1){
            in[edges[i]]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        boolean [] visited= new boolean[edges.length];
            
        while(!q.isEmpty()){
            int rm= q.poll();
            visited[rm]=true;
            if(edges[rm]!= -1){
                in[edges[rm]]--;
            }

            if(edges[rm]!=-1){
            if(in[edges[rm]]==0){
                q.add(edges[rm]);
            }
            }
        }
        int ans=-1;

        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                visited[i]=true;
                int c=1;
                int nbrs=edges[i];
                while(nbrs!=i){
                    c++;
                    visited[nbrs]=true;
                    nbrs= edges[nbrs];
                }
                ans=Math.max(ans,c);
            }
            
        }
        return ans;
    }
       
}