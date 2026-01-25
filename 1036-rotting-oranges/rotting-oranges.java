class Solution {
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        int ans=0;
        int [] r={-1,1,0,0};
        int [] c={0,0,1,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
            }
        }
                while(!q.isEmpty()){
                    int [] A= q.poll();
                    int cr= A[0];
                    int cc= A[1];
                    int time= A[2];
                    ans=Math.max(ans,time);

                    for(int k=0;k<r.length;k++){
                        int nr= cr+ r[k];
                        int nc= cc+ c[k];
                        if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                            grid[nr][nc]=2;// make it unfresh
                            q.add(new int[]{nr,nc,time+1});
                        }
                    }

                }
      

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return ans;

    }
}