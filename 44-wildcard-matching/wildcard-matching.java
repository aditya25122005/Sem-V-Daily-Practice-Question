class Solution {
    public boolean isMatch(String s, String p) {
        Boolean [][] dp= new Boolean[s.length()][p.length()];
        return Solve(s,p,0,0,dp);
    }
    public static boolean Solve(String s, String p, int i, int j,Boolean[][] dp){
    //    boolean ans=false;
        if(i==s.length() && j==p.length()){
            return true;
        }
        if(i==s.length()){
            if(allstar(p,j)){
                return true;
            }
            return false;
        }
        if(j==p.length()){
            return false;
        }
        if(dp[i][j] != null) return dp[i][j];
        boolean ans=false;
        if(s.charAt(i)== p.charAt(j) || p.charAt(j)=='?'){
            ans = ans ||  Solve(s,p,i+1,j+1,dp);
        }
        if(p.charAt(j)=='*'){
            ans = ans || Solve(s,p,i,j+1,dp);
            ans= ans || Solve(s,p,i+1,j,dp);
            ans= ans ||  Solve(s,p,i+1,j+1,dp);
        }
        return dp[i][j] = ans;
    }
    public static boolean allstar(String p, int j){
        for(int i=j;i<p.length();i++){
            if(p.charAt(i) != '*') return false;
        }
        return true;
    }
}