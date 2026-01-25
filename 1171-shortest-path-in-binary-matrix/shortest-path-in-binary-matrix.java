class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;

        if(grid[0][0]==1 || grid[n-1][m-1]==1) return -1;

        int [] r={-1,1,0,0,-1,-1,1,1};
        int [] c={0,0,1,-1,-1,1,-1,1};
        int ans=Integer.MAX_VALUE;
        boolean [][] visited= new boolean[n][m];

        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,0,1});
        visited[0][0]= true;
        while(!q.isEmpty()){
            int [] A= q.poll();
            int cr= A[0];
            int cc= A[1];
            int dist= A[2];
            if(cr==n-1 && cc==m-1){
                ans= Math.min(ans,dist);
            }
            for(int k=0;k<r.length;k++){
                int nr= cr+r[k];
                int nc= cc+c[k];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==0 && visited[nr][nc]==false){
                    visited[nr][nc]=true;
                    q.add(new int[]{nr,nc,dist+1});
                }
            }
        }
        return ans==Integer.MAX_VALUE? -1:ans;
    
    }
}