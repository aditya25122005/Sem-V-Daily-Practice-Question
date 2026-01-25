class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n= mat.length;
        int m= mat[0].length;
        int [][] ans= new int[n][m];// --> jaha pehle se 0 hai vaha 0 distance
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                    q.add(new int[]{i,j,0});
                }
                else{
                    ans[i][j]=-1;
                }
            }
        }
        int [] r={-1,1,0,0};
        int [] c={0,0,1,-1};
        while(!q.isEmpty()){
            int [] A= q.poll();
            int cr= A[0];
            int cc= A[1];
            int dis= A[2];

            for(int k=0;k<r.length;k++){
                int nr= cr+ r[k];
                int nc= cc+ c[k];
                if(nr>=0 && nr<n && nc>=0 && nc<m && ans[nr][nc]==-1){
                    q.add(new int[]{nr,nc,dis+1});
                    ans[nr][nc]=dis+1;
                }
            }


        }
        return ans;
    }
}