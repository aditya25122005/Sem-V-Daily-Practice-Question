class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp= new int[m][n];
        for(int [] a:dp) Arrays.fill(a, -1);
        return Count(0, 0, m-1, n-1,dp);
    }
    public static int Count(int cr, int cc, int er, int ec,int [][]dp){
        if(cr==er && cc==ec){
            return 1;
        }
        if(cr<0 || cr>er || cc<0 || cc>ec){
            return 0;
        }
        if(dp[cr][cc]!=-1) return dp[cr][cc];
        int ans=0;
        ans+=Count(cr+1,cc,er,ec,dp);
        ans+=Count(cr, cc+1, er, ec,dp);

        return dp[cr][cc]=ans;
    }
}