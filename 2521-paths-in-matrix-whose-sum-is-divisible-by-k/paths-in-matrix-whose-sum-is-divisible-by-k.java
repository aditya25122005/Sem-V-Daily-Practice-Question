class Solution {
    static int MOD=1000000007;
    public int numberOfPaths(int[][] grid, int k) {
         MOD=1000000007;
        int [][][]dp= new int[grid.length][grid[0].length][k];
        for(int[][]A:dp){
            for(int [] a:A){
                Arrays.fill(a,-1);
            }
        }

        return  Solve(grid,0,0,k,0,dp)%MOD;
    }
    public static int Solve(int[][] grid, int cr, int cc, int k, long sum, int[][][]dp){
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
        
        int a= Solve(grid,cr,cc+1,k,sum,dp);
        int b= Solve(grid,cr+1,cc,k,sum,dp);
        
        return dp[cr][cc][mod] = (a+b)%MOD;
    }
}