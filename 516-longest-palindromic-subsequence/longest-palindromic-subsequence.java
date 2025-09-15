class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp= new int[s.length()][s.length()];
       
        for(int[]a:dp){
            Arrays.fill(a,-1);
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
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(s.charAt(i)==s.charAt(j)){
            ans=2+Solve(s,i+1,j-1,dp);
            dp[i][j]=ans;
        }else{
            int f=Solve(s,i+1,j,dp);
            int se=Solve(s,i,j-1,dp);
            ans+=Math.max(f,se);
            dp[i][j]=ans;
        }
        return dp[i][j]=ans;

    }
}