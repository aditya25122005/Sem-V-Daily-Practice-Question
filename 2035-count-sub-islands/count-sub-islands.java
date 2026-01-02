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
        int n = grid2.length;
        int m= grid2[0].length;
        boolean flag= true;
        if(grid1[cr][cc]!=1){
            flag=false;
        }
        
        int [] r={-1,1,0,0};
        int [] c={0,0,-1,1};
        boolean ans=true;
        for(int i=0;i<r.length;i++){
            int nr= cr+ r[i];
            int nc= cc+ c[i];
            if(nr>=0 && nc>=0 && nr<n && nc<m && grid2[nr][nc]==1){
                grid2[nr][nc]=0;
                boolean b = Solve(nr,nc,grid2,grid1);
                ans= ans &&b;
            }

        }

        return ans && flag;

    }

}