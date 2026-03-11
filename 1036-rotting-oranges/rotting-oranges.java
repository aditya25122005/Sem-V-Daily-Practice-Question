class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n= grid.length;
        int m= grid[0].length;
        boolean [][] visited= new boolean [n][m];

        Queue<int[]> q= new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int []{i,j,0});
                    visited[i][j]=true;
                }
            }
        }
        // int time=0;
        int ans=0;
        int [] r={-1,1,0,0};
        int [] c={0,0,-1,1};
        while(!q.isEmpty()){
            int [] rm = q.poll();
            int cr= rm[0];
            int cc= rm[1];
            int time= rm[2];
            boolean fresh=false;
            for(int i=0;i<r.length;i++){
                int nr= cr+r[i];
                int nc= cc+c[i];
                int nt= time+1;
                if(nr>=0 && nc>=0 && nr<n && nc<m && !visited[nr][nc] && grid[nr][nc]==1){
                    fresh=true;
                    visited[nr][nc]=true;
                    grid[nr][nc]=2;
                    ans=Math.max(ans,nt);

                    q.add(new int[]{nr,nc,nt});
                }
            }
            // if(fresh) time++;

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return ans;


    }
}