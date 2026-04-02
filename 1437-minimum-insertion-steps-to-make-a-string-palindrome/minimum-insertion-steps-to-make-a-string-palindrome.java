class Solution {
    public int minInsertions(String s) {
        Integer [][] dp= new Integer[s.length()][s.length()];
        return Solve(s,0,s.length()-1,dp);
    }
    public static int Solve(String s, int i, int j,Integer [][] dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j] != null) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        if(s.charAt(i)==s.charAt(j)){
            ans= Math.min(ans, Solve(s,i+1,j-1,dp));
        }
        else{
            ans= Math.min(ans, 1+ Solve(s,i+1,j,dp));
            ans= Math.min(ans, 1+ Solve(s,i,j-1,dp));
        }
        return dp[i][j] = ans;

    }
}