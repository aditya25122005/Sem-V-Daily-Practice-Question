class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double den=1.0;
        Double [][][] dp= new Double[n][n][k+1];
       

        for(int i=0;i<k;i++){
            den*=8.0;
        }
        double num = Solve(n,row, column, k,dp);
        return (double)num/den;


    }
    public static double Solve(int n, int cr, int cc, int k , Double[][][] dp){
        if(cr<0 || cc<0 || cr>=n || cc>=n){
            return 0.0;
        }

        if(k==0){
            return 1.0;
        }
        if(dp[cr][cc][k]!=null){
            return dp[cr][cc][k];
        }
        double A=0;
        A+=Solve(n,cr-2,cc+1,k-1,dp);
        A+=Solve(n,cr-1,cc+2,k-1,dp);
        A+=Solve(n,cr+1,cc+2,k-1,dp);
        A+=Solve(n,cr+2,cc+1,k-1,dp);
        A+=Solve(n,cr+2,cc-1,k-1,dp);
        A+=Solve(n,cr+1,cc-2,k-1,dp);
        A+=Solve(n,cr-1,cc-2,k-1,dp);
        A+=Solve(n,cr-2,cc-1,k-1,dp);
        return dp[cr][cc][k] = A;
    }
}