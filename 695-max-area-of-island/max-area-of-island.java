class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        int [] r={-1,1,0,0};
        int [] c={0,0,-1,1};
        int ans=0;
        int curr=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    curr=1;
                    q.add(new int[]{i,j});
                    grid[i][j]=0;
                    while(!q.isEmpty()){
                        int [] A= q.poll();
                        int cr= A[0];
                        int cc= A[1];
                        for(int k=0;k<r.length;k++){
                            int nr= cr+r[k];
                            int nc= cc+c[k];
                            if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                                q.add(new int[]{nr,nc});
                                curr++;
                                grid[nr][nc]=0;
                            }
                        }
                    }
                    ans=Math.max(ans,curr);
                    

                }
            }
        }
        return ans;
    }
}