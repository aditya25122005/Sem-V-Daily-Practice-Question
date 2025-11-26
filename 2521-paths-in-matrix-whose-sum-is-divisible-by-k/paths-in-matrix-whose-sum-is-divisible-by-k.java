class Solution {
    static int MOD=1000000007;
    public int numberOfPaths(int[][] grid, int k) {
         MOD=1000000007;
        long [][][]dp= new long[grid.length][grid[0].length][k];
        for(long[][]A:dp){
            for(long [] a:A){
                Arrays.fill(a,-1);
            }
        }

        return (int) (Solve(grid,0,0,k,0,dp)%MOD);
    }
    public static long Solve(int[][] grid, int cr, int cc, int k, long sum, long[][][]dp){
        if(cr>=grid.length || cc>=grid[0].length ){
            return 0;
        }
        sum+= grid[cr][cc];
        int mod=(int)(sum%k);
        if(dp[cr][cc][mod]!=-1){
            return dp[cr][cc][mod];
        }
        
        if(cr==grid.length-1 && cc==grid[0].length-1){
            return dp[cr][cc][mod]= mod==0? 1:0;
        }
        
        long a= Solve(grid,cr,cc+1,k,sum,dp);
        long b= Solve(grid,cr+1,cc,k,sum,dp);
        
        return dp[cr][cc][mod] = (a+b)%MOD;
    }
}