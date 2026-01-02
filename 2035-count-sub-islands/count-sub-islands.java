class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid2.length;
        int m=grid2[0].length;
        int c=0;
        for(int i=0; i<n ;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1){
                   if(Solve(i,j, grid2,grid1)){
                    c++;
                   }
                }
            }
        }
        return c;
    }
    public static boolean Solve(int cr, int cc, int [][] grid2, int[][] grid1){
        if(cr<0 || cc<0 || cr>=grid2.length || cc>=grid2[0].length || grid2[cr][cc]==0){
            return true;
        }
        boolean flag=true;
        if(grid1[cr][cc]!=1){
            flag=false;
        }
        grid2[cr][cc]=0;

        int [] r={-1,1,0,0};
        int [] c={0,0,-1,1};
        boolean ans=true;
        for(int i=0;i<r.length;i++){
            boolean b= Solve(cr+r[i],cc+c[i],grid2,grid1);
            ans = ans&&b;
        }
        return ans && flag;
    }
}