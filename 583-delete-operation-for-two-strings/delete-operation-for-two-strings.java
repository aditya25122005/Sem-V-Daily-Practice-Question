class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] dp= new Integer[word1.length()][word2.length()];
        return Solve(word1,word2,0,0,dp);
    }
    public static int Solve(String word1, String word2, int i, int j,Integer[][] dp){
        if(i>= word1.length()){
            return word2.length()-j;
        }
        if(j>= word2.length()){
            return word1.length()-i;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }

        int ans=Integer.MAX_VALUE;
        if(word1.charAt(i) != word2.charAt(j)){
            ans= Math.min(ans, 1+ Solve(word1,word2,i+1,j,dp));
            ans=Math.min(ans, 1+ Solve(word1,word2,i,j+1,dp));
            ans=Math.min(ans, 2+ Solve(word1,word2,i+1,j+1,dp));
        }
        else{
            ans= Math.min(ans, Solve(word1,word2,i+1,j+1,dp));
        }
        return dp[i][j] = ans;
    }
}