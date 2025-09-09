class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int [][] dp= new int[n+1][m+1];
        for(int [] a:dp){
            Arrays.fill(a,-1);
        }
        return Match(s,p,0,0,dp);

    }
    public static boolean Match(String s, String p, int i, int j, int[][]dp){
        
        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }
        boolean ans;
        if(i==s.length() && j==p.length() ){
            ans=true;
        }
        else if(j==p.length()){
            ans=false;
        }
        else if(i==s.length()){
            ans=allStars(j,p);
        }
        else{
        char sc= s.charAt(i);
        char pc = p.charAt(j);
     
        if(sc==pc || pc=='?'){
            ans= Match(s,p,i+1,j+1,dp);
        }else if(pc=='*'){
            ans=Match(s,p,i,j+1,dp) || Match(s,p,i+1,j,dp);
        }else{
            ans=false;
        }

    }
        dp[i][j] = ans ? 1 : 0;
        return ans;
        

    }
    public static boolean allStars(int i, String p){
        for(int j=i;j<p.length();j++){
            if(p.charAt(j)!='*'){
                return false;
            }
        }
        return true;
    }
}