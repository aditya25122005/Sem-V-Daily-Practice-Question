class Solution {
    public int knightDialer(int n) {
        char [][] grid =  {{'1','2','3'},{'4','5','6'},{'7','8','9'},
        {'*','0','#'}};
        int [][][] dp = new int[grid.length][grid[0].length][n+1];
        for(int [][] A: dp){
            for(int [] a: A) Arrays.fill(a,-1);
        }
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>='0' && grid[i][j]<='9'){
                    count = (count+ Solve(i,j,grid,n,0,dp))%1000000007;
                }
            }
        }
        return count;
    }
    public static int Solve(int cr, int cc,char [][] grid, int n, int curr, int[][][] dp){
        int mod = 1000000007;
        int m= grid[0].length;

        int [] r ={-2,2,-2,2,-1,1,1,-1};
        int [] c ={-1,1,1,-1,-2,2,-2,2};


        if(cr<0 || cc<0 || cr>= grid.length || cc>= grid[0].length || grid[cr][cc]=='#' || grid[cr][cc]=='*'){
            return 0;
        }
        if(curr==n-1){
            return 1;
        }
        if(dp[cr][cc][curr] != -1) return dp[cr][cc][curr];

        int ans=0;

        for(int i=0;i<r.length;i++){
           ans = (ans+ Solve(cr+ r[i],cc+ c[i] , grid, n, curr+1,dp))%mod;
        
        }

        return dp[cr][cc][curr] = ans%mod;
    }
}