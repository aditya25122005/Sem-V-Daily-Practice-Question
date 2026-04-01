class Solution {
    public int longestPalindromeSubseq(String s) {
        Integer[][] dp= new Integer[s.length()][s.length()];
        return Solve(s,0,s.length()-1,dp);
    }
    public static int Solve(String s, int i, int j,Integer[][] dp){
        if(i==j){
            return 1;
        }
        if(j<i){
            return 0;
        }
        if(dp[i][j]!=null) return dp[i][j];

        int A=0;
        int B=0;
        int C=0;
        if(s.charAt(i)==s.charAt(j)){
            A= 2+ Solve(s, i+1,j-1,dp);
        }
        else{
            B= Solve(s,i+1,j,dp);
            C= Solve(s,i,j-1,dp);
        }
        return dp[i][j] = Math.max(A,Math.max(B,C));
    }
}