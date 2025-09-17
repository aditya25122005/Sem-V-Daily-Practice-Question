class Solution {
    public int uniquePathsIII(int[][] grid) {
        int si=0;
        int sj=0;
        int n=grid.length;
        int m=grid[0].length;
        int TotalZero=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    si=i;
                    sj=j;
                }
                if(grid[i][j]==0){
                    TotalZero++;
                }
            }
        }
        int [] ans= new int[1];
        int [] r={-1,0,1,0};
        int [] c={0,1,0,-1};
        Unique(grid,n,m,si,sj,TotalZero,0,ans,r,c);
        return ans[0];

    }
    public static void Unique(int[][] grid,int n, int m, int si, int sj, int TotalZero, int currZero,int[] ans, int []r, int[]c){
        if(grid[si][sj]==2){
            if(currZero==TotalZero){
                ans[0]++;
            }
            return;
        }


        grid[si][sj]=-1;
        for(int i=0;i<4;i++){
            int nRow=si+r[i];
            int nCol=sj+c[i];
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]!=-1){
                if(grid[nRow][nCol]!=2) currZero++;
                Unique(grid,n,m,nRow,nCol,TotalZero,currZero,ans,r,c);
                if(grid[nRow][nCol]!=2) currZero--;
            }
        }
        grid[si][sj]=0;
    }
}