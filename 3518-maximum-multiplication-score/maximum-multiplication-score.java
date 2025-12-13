class Solution {
    public long maxScore(int[] a, int[] b) {
        long[][] dp= new long[a.length][b.length];
        for(long [] D:dp) Arrays.fill(D,Long.MIN_VALUE);

        return Solve(a,b,0,0,dp);
    }
    public static long Solve(int[]a, int[]b, int i, int j, long[][] dp){
        if(i==a.length){
            return 0;
        }
        if(j==b.length){
            return Long.MIN_VALUE/3;
        }
        if(dp[i][j]!=Long.MIN_VALUE) return dp[i][j];
        long prod1=0;
        long prod2=0;
        prod1= (long)a[i]*b[j]+(Solve(a,b,i+1,j+1,dp));
        prod2=Solve(a,b,i,j+1,dp);
        return dp[i][j] =  Math.max(prod1,prod2);
    }
}