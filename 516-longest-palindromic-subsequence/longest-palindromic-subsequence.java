class Solution {
    public int longestPalindromeSubseq(String s) {
        int n= s.length();
        int [][] dp= new int[n][n];
        for(int [] A: dp){
            Arrays.fill(A,-1);
        }
        return Solve(s,0,s.length()-1,dp);
    }
    
    public static int Solve(String s, int i, int j, int[][] dp){
        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        if(s.charAt(i)==s.charAt(j)){
            a=2+Solve(s,i+1,j-1,dp);
        }
        else{
            b=Solve(s,i+1,j,dp);
            c=Solve(s,i+1,j-1,dp);
            d=Solve(s,i,j-1,dp);
        }
        return dp[i][j] = Math.max(Math.max(a,b),Math.max(c,d));
    }
    
}