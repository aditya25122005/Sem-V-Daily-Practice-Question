class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp= new Integer[text1.length()][text2.length()];
        return Solve(text1,text2,0,0,dp);
    }
    public static int Solve(String text1, String text2, int i, int j,Integer[][] dp){
        if(i>= text1.length() || j>= text2.length()){
            return 0;
        }
        if(dp[i][j] != null) return dp[i][j];
        int A=0;
        int B=0;
        
        if(text1.charAt(i)== text2.charAt(j)){
            A= 1+ Solve(text1, text2, i+1, j+1,dp);
        }
        else{
            B= Math.max(B,Solve(text1,text2, i+1,j,dp));
            B=Math.max(B, Solve(text1,text2,i,j+1,dp));
            // B= Math.max(B, Solve(text1, text2,i+1,j+1,dp));
        }
        return dp[i][j] = Math.max(A,B);
    }
}