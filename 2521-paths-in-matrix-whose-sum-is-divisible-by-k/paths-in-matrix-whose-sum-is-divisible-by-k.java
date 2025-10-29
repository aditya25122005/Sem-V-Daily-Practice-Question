class Solution {
    static int mod=1000000007;

    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp= new int[grid.length][grid[0].length][k]; 
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                for(int l=0;l<k;l++ ){
                    dp[i][j][l]=-1;
                }
            }
        }
        return (int)Solve(grid,k,0,0,0,dp);
        
    }
 
    public static long Solve(int[][] grid, int k,long curr, int cr, int cc, int[][][]dp){
        if(cr>=grid.length || cc>=grid[0].length ){
            return 0;
        }
        if(dp[cr][cc][(int)(curr%k)]!=-1){
            return dp[cr][cc][(int)(curr%k)];
        }
        if(cr==grid.length-1 && cc== grid[0].length-1){
            if((curr+grid[cr][cc])%k==0){
               
                return 1;
            }
            else{
                return 0;
            }
        }
        long a=Solve(grid,k,curr+grid[cr][cc],cr+1,cc,dp);
        long b=Solve(grid,k,curr+grid[cr][cc],cr,cc+1,dp);

        return dp[cr][cc][(int)(curr%k)] = (int)((a+b)%mod);

    }
}