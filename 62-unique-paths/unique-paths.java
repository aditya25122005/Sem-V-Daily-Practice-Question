class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp= new int[m][n];
        for(int [] A:dp){
            Arrays.fill(A,-1);
        }
        return Solve(0,0,m,n,dp);
    }
    public static int Solve(int cr, int cc, int m, int n, int[][] dp){
        if(cr<0 || cc<0 || cr>=m || cc>=n){
            return 0;
        }
        if(cr==m-1 && cc==n-1){
            return 1;
        }
        if(dp[cr][cc]!=-1) return dp[cr][cc];
        int ans=0;
        int [][] dir={{0,1},{1,0}};
        for(int []D:dir){
            ans+= Solve(cr+D[0],cc+D[1],m,n,dp);
        }

        return dp[cr][cc]  =ans;
    }
}