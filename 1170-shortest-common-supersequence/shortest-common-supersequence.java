class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        Integer[][] dp= new Integer[str1.length()+1][str2.length()+1];
        
       Solve(str1, str2, 0, 0,dp);
        return build(str1,str2, 0,0, dp);
    }
    public static String build(String s1, String s2, int i, int j, Integer[][] dp){
        if(i>= s1.length()){
            return s2.substring(j);
        }
        if(j>= s2.length()){
            return s1.substring(i);
        }
        if(dp[i][j] == null) Solve(s1, s2, i, j, dp);

        if(s1.charAt(i)== s2.charAt(j)){
            return s1.charAt(i) + build(s1,s2,i+1,j+1,dp);
        }
        int down = Solve(s1, s2, i+1, j, dp);
        int right = Solve(s1, s2, i, j+1, dp);

        if(dp[i][j] == 1 + down){
            return s1.charAt(i) + build(s1,s2,i+1,j,dp);
        } else {
            return s2.charAt(j) + build(s1,s2,i,j+1,dp);
        }
        
    }
    public static int  Solve(String s1, String s2, int i, int j,Integer[][] dp){

        if(i>=s1.length()){
            return s2.length()-j;
        }
        if(j>= s2.length()){
            return s1.length()-i;
        }
        if(dp[i][j] != null) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        if(s1.charAt(i) != s2.charAt(j)){
            ans= Math.min(ans, 1+Solve(s1,s2,i+1,j,dp));
            ans= Math.min(ans, 1+Solve(s1,s2,i,j+1,dp));
        }
        else{
            ans= Math.min(ans, 1+Solve(s1,s2,i+1,j+1,dp));
        }
        return dp[i][j] = ans;
    }
}