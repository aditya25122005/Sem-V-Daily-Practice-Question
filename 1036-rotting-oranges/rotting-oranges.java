class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
            }
        }
        int [] R = {0,0,-1,1};
        int [] C = {-1,1,0,0};
        int ans = 0;
        while(!q.isEmpty()){
            int [] rm = q.poll();
            int r = rm[0];
            int c = rm[1];
            int t = rm[2];
            for(int i=0;i<R.length;i++){
                int nr = r+R[i];
                int nc = c+C[i];
                int nt = t+1;
                if(nr<n && nc<m && nr>=0 && nc>=0 && grid[nr][nc]==1){
                    grid[nr][nc] = 2;
                    q.add(new int[]{nr,nc,nt});
                    ans = Math.max(ans,nt);
                }
            }

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return ans;
    }
}