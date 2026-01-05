class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m= mat[0].length;
        int [][] ans= new int[n][m];

        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                    q.add(new int[]{i,j});
                }
                else{
                    ans[i][j]=-1;
                }
            }
        }
        int [] r={-1,1,0,0};
        int [] c={0,0,1,-1};
        while(!q.isEmpty()){
            int [] rm=q.poll();
            int row= rm[0];
            int col= rm[1];

            for(int i=0;i<r.length;i++){
                int nr=row+r[i];
                int nc=col+c[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m && ans[nr][nc]==-1){
                    ans[nr][nc]=ans[row][col]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return ans;
        
    }

}